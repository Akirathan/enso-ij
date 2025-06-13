package org.enso.ij;

import com.intellij.psi.tree.TokenSet;
import org.enso.ij.psi.EnsoTypes;

public interface EnsoTokenSets {
  TokenSet IDENTIFIERS = TokenSet.create(EnsoTypes.IDENTIFIER);
  TokenSet COMMENTS = TokenSet.create(
      EnsoTypes.COMMENT,
      EnsoTypes.MULTILINE_COMMENT
  );
  TokenSet STRINGS = TokenSet.create(
      EnsoTypes.STRING_SINGLE,
      EnsoTypes.STRING_DOUBLE
    );
}
