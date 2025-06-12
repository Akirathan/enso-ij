package org.enso.ij.parser;

import static org.junit.Assert.assertNotNull;

import com.intellij.testFramework.ParsingTestCase;
import org.enso.ij.psi.EnsoTypes;
import org.junit.Test;


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
    assertEquals("Single child", 1, rootNode.getChildren(null).length);
    var module = parsed.getNode().getFirstChildNode();
    assertEquals(EnsoTypes.MODULE, module.getElementType());
    var multilineComment = module.getFirstChildNode();
    assertEquals(EnsoTypes.MULTILINE_COMMENT, multilineComment.getElementType());
  }

  @Override
  protected String getTestDataPath() {
    return "src/test/testData";
  }
}
