package org.enso.ij.parser;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNotNull;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.testFramework.ParsingTestCase;
import java.util.function.Predicate;
import org.enso.ij.psi.EnsoTypes;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


public class EnsoParserTest extends ParsingTestCase {
  public EnsoParserTest() {
    super("", "enso", new EnsoParserDefinition());
  }

  public void testTopLevelMethod() {
    var parsed = this.parseFile("Foo.enso", "main = 42");
    var rootNode = parsed.getNode();
    var module = rootNode.getFirstChildNode();
    assertEquals(EnsoTypes.MODULE, module.getElementType());
    var binding = module.getFirstChildNode();
    assertEquals(EnsoTypes.BINDING, binding.getElementType());
    var method = binding.getFirstChildNode();
    assertEquals(EnsoTypes.METHOD, method.getElementType());
  }

  public void testMultilineComment() {
    var code = """
        ## Multiline comment
        """;
    var parsed = parseFile("Foo.enso", code);
    var rootNode = parsed.getNode();
    var multilineComment = findRecursively(rootNode, node -> node.getElementType() == EnsoTypes.MULTILINE_COMMENT);
    assertThat(multilineComment, is(notNullValue()));
  }

  public void testMultilineComment_2() {
    var code = """
        ## comment
           Another line of comment
        main = 42
        """;
    var parsed = parseFile("Foo.enso", code);
    var rootNode = parsed.getNode();
    var multilineComment = findRecursively(rootNode, node -> node.getElementType() == EnsoTypes.MULTILINE_COMMENT);
    assertThat(multilineComment, is(notNullValue()));
    var method = findRecursively(rootNode, node -> node.getElementType() == EnsoTypes.METHOD);
    assertThat(method, is(notNullValue()));
    assertThat(method.getText(), is("main = 42"));
  }

  public void testImports_1() {
    var code = """
        from Standard.Base import all
        import Standard.Base.Data.Vector
        """;
    var parsed = parseFile("Foo.enso", code);
    var rootNode = parsed.getNode();
    assertNoErrors(rootNode);
    var imp = findRecursivelyByElemType(rootNode, EnsoTypes.IMPORT_RULE);
    var fromImport = findRecursivelyByElemType(rootNode, EnsoTypes.FROM_IMPORT);
    assertThat(imp, is(notNullValue()));
    assertThat(fromImport, is(notNullValue()));
    assertThat(imp.getText(), is("import Standard.Base.Data.Vector"));
    assertThat(fromImport.getText(), is("from Standard.Base import all"));
  }

  private static void assertNoErrors(ASTNode rootNode) {
    var errorNode = findRecursively(rootNode, node -> node.getPsi() instanceof PsiErrorElement);
    assertThat("AST contains errors:\n" + printAST(rootNode), errorNode, is(nullValue()));
  }

  @Override
  protected String getTestDataPath() {
    return "src/test/testData";
  }

  private static String printAST(ASTNode root) {
    var sb = new StringBuilder();
    printAST(root, sb, 0);
    return sb.toString();
  }

  private static void printAST(ASTNode node, StringBuilder sb, int indent) {
    sb.append(" ".repeat(indent));
    var elementType = node.getElementType();
    sb.append(elementType);
    if (node.getPsi() instanceof PsiErrorElement err) {
      sb.append("(")
        .append(err.getErrorDescription())
        .append(")");
    }
    sb.append("\n");
    indent += 2;
    var child = node.getFirstChildNode();

    while (child != null) {
      printAST(child, sb, indent);
      child = child.getTreeNext();
    }
  }

  private static ASTNode  findRecursivelyByElemType(ASTNode root, IElementType elemType) {
    return findRecursively(root, node -> node.getElementType() == elemType);
  }

  private static ASTNode findRecursively(ASTNode root, Predicate<ASTNode> predicate) {
    if (predicate.test(root)) {
      return root;
    }
    ASTNode child = root.getFirstChildNode();
    while (child != null) {
      ASTNode found = findRecursively(child, predicate);
      if (found != null) {
        return found;
      }
      child = child.getTreeNext();
    }
    return null;
  }
}
