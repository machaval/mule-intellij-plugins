// This is a generated file. Not intended for manual editing.
package org.mule.lang.raml.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.mule.lang.raml.parser.psi.RamlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RamlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ALPHA) {
      r = alpha(b, 0);
    }
    else if (t == ALPHADIGIT) {
      r = alphadigit(b, 0);
    }
    else if (t == ATTRIBUTE) {
      r = attribute(b, 0);
    }
    else if (t == COMPOSITE_TYPE) {
      r = composite_type(b, 0);
    }
    else if (t == DIGIT) {
      r = digit(b, 0);
    }
    else if (t == DIGITS) {
      r = digits(b, 0);
    }
    else if (t == DISCRETE_TYPE) {
      r = discrete_type(b, 0);
    }
    else if (t == DOMAINLABEL) {
      r = domainlabel(b, 0);
    }
    else if (t == END_OF_LINE) {
      r = end_of_line(b, 0);
    }
    else if (t == ESCAPE) {
      r = escape(b, 0);
    }
    else if (t == EXTENSION_TOKEN) {
      r = extension_token(b, 0);
    }
    else if (t == EXTRA) {
      r = extra(b, 0);
    }
    else if (t == GENERICURL) {
      r = genericurl(b, 0);
    }
    else if (t == HEX) {
      r = hex(b, 0);
    }
    else if (t == HIALPHA) {
      r = hialpha(b, 0);
    }
    else if (t == HOST) {
      r = host(b, 0);
    }
    else if (t == HOSTNAME) {
      r = hostname(b, 0);
    }
    else if (t == HOSTNUMBER) {
      r = hostnumber(b, 0);
    }
    else if (t == HOSTPORT) {
      r = hostport(b, 0);
    }
    else if (t == HPATH) {
      r = hpath(b, 0);
    }
    else if (t == HSEGMENT) {
      r = hsegment(b, 0);
    }
    else if (t == HTTPSURL) {
      r = httpsurl(b, 0);
    }
    else if (t == HTTPURL) {
      r = httpurl(b, 0);
    }
    else if (t == IANA_TOKEN) {
      r = iana_token(b, 0);
    }
    else if (t == IETF_TOKEN) {
      r = ietf_token(b, 0);
    }
    else if (t == IN_LINE_WHITESPACE) {
      r = in_line_whitespace(b, 0);
    }
    else if (t == INTEGER_NUMBER) {
      r = integer_number(b, 0);
    }
    else if (t == IP_SCHEMEPART) {
      r = ip_schemepart(b, 0);
    }
    else if (t == LOGIN) {
      r = login(b, 0);
    }
    else if (t == LOWALPHA) {
      r = lowalpha(b, 0);
    }
    else if (t == MIMETYPE) {
      r = mimetype(b, 0);
    }
    else if (t == NATIONAL) {
      r = national(b, 0);
    }
    else if (t == NON_WHITESPACE) {
      r = non_whitespace(b, 0);
    }
    else if (t == NON_WHITESPACE_WORD) {
      r = non_whitespace_word(b, 0);
    }
    else if (t == OTHERURL) {
      r = otherurl(b, 0);
    }
    else if (t == PARAMETER) {
      r = parameter(b, 0);
    }
    else if (t == PASSWORD) {
      r = password(b, 0);
    }
    else if (t == PORT) {
      r = port(b, 0);
    }
    else if (t == PUNCTUATION) {
      r = punctuation(b, 0);
    }
    else if (t == RAML_BASE_URI) {
      r = raml_base_uri(b, 0);
    }
    else if (t == RAML_COMMENT) {
      r = raml_comment(b, 0);
    }
    else if (t == RAML_CONTENT) {
      r = raml_content(b, 0);
    }
    else if (t == RAML_CONTENT_LIST) {
      r = raml_content_list(b, 0);
    }
    else if (t == RAML_DIRECTIVE) {
      r = raml_directive(b, 0);
    }
    else if (t == RAML_DIRECTIVE_LIST) {
      r = raml_directive_list(b, 0);
    }
    else if (t == RAML_DIRECTIVE_RAML) {
      r = raml_directive_raml(b, 0);
    }
    else if (t == RAML_DIRECTIVE_TAG) {
      r = raml_directive_tag(b, 0);
    }
    else if (t == RAML_DOCUMENT) {
      r = raml_document(b, 0);
    }
    else if (t == RAML_DOCUMENT_END) {
      r = raml_document_end(b, 0);
    }
    else if (t == RAML_DOCUMENT_LIST) {
      r = raml_document_list(b, 0);
    }
    else if (t == RAML_IRECTIVES_END) {
      r = raml_irectives_end(b, 0);
    }
    else if (t == RAML_MEDIA_TYPE) {
      r = raml_media_type(b, 0);
    }
    else if (t == RAML_RESOURCE) {
      r = raml_resource(b, 0);
    }
    else if (t == RAML_RESOURCE_TYPES) {
      r = raml_resource_types(b, 0);
    }
    else if (t == RAML_SCHEMAS) {
      r = raml_schemas(b, 0);
    }
    else if (t == RAML_SECURED_BY) {
      r = raml_secured_by(b, 0);
    }
    else if (t == RAML_SECURITY_SCHEMES) {
      r = raml_security_schemes(b, 0);
    }
    else if (t == RAML_STREAM) {
      r = raml_stream(b, 0);
    }
    else if (t == RAML_TAG_HANDLE) {
      r = raml_tag_handle(b, 0);
    }
    else if (t == RAML_TAG_PREFIX) {
      r = raml_tag_prefix(b, 0);
    }
    else if (t == RAML_TITLE) {
      r = raml_title(b, 0);
    }
    else if (t == RAML_TRAITS) {
      r = raml_traits(b, 0);
    }
    else if (t == RAML_VERSION) {
      r = raml_version(b, 0);
    }
    else if (t == RESERVED) {
      r = reserved(b, 0);
    }
    else if (t == SAFE) {
      r = safe(b, 0);
    }
    else if (t == SCHEME) {
      r = scheme(b, 0);
    }
    else if (t == SCHEMEPART) {
      r = schemepart(b, 0);
    }
    else if (t == SEARCH) {
      r = search(b, 0);
    }
    else if (t == SUBTYPE) {
      r = subtype(b, 0);
    }
    else if (t == TOKEN) {
      r = token(b, 0);
    }
    else if (t == TOPLABEL) {
      r = toplabel(b, 0);
    }
    else if (t == TSPECIALS) {
      r = tspecials(b, 0);
    }
    else if (t == TYPE) {
      r = type(b, 0);
    }
    else if (t == UCHAR) {
      r = uchar(b, 0);
    }
    else if (t == UNRESERVED) {
      r = unreserved(b, 0);
    }
    else if (t == URL) {
      r = url(b, 0);
    }
    else if (t == URLPATH) {
      r = urlpath(b, 0);
    }
    else if (t == USER) {
      r = user(b, 0);
    }
    else if (t == VALUE) {
      r = value(b, 0);
    }
    else if (t == X_TOKEN) {
      r = x_token(b, 0);
    }
    else if (t == XCHAR) {
      r = xchar(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return whitespace(b, l + 1);
  }

  /* ********************************************************** */
  // lowalpha | hialpha
  public static boolean alpha(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alpha")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<alpha>");
    r = lowalpha(b, l + 1);
    if (!r) r = hialpha(b, l + 1);
    exit_section_(b, l, m, ALPHA, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // alpha | digit
  public static boolean alphadigit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alphadigit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<alphadigit>");
    r = alpha(b, l + 1);
    if (!r) r = digit(b, l + 1);
    exit_section_(b, l, m, ALPHADIGIT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // token
  public static boolean attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<attribute>");
    r = token(b, l + 1);
    exit_section_(b, l, m, ATTRIBUTE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "message" | "multipart" | extension_token
  public static boolean composite_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "composite_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<composite type>");
    r = consumeToken(b, "message");
    if (!r) r = consumeToken(b, "multipart");
    if (!r) r = extension_token(b, l + 1);
    exit_section_(b, l, m, COMPOSITE_TYPE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
  public static boolean digit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "digit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<digit>");
    r = consumeToken(b, "0");
    if (!r) r = consumeToken(b, "1");
    if (!r) r = consumeToken(b, "2");
    if (!r) r = consumeToken(b, "3");
    if (!r) r = consumeToken(b, "4");
    if (!r) r = consumeToken(b, "5");
    if (!r) r = consumeToken(b, "6");
    if (!r) r = consumeToken(b, "7");
    if (!r) r = consumeToken(b, "8");
    if (!r) r = consumeToken(b, "9");
    exit_section_(b, l, m, DIGIT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 1*digit
  public static boolean digits(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "digits")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<digits>");
    r = digits_0(b, l + 1);
    r = r && digit(b, l + 1);
    exit_section_(b, l, m, DIGITS, r, false, null);
    return r;
  }

  // 1*
  private static boolean digits_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "digits_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, "1")) break;
      if (!empty_element_parsed_guard_(b, "digits_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // "text" | "image" | "audio" | "video" |
  //               "application" | extension_token
  public static boolean discrete_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "discrete_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<discrete type>");
    r = consumeToken(b, "text");
    if (!r) r = consumeToken(b, "image");
    if (!r) r = consumeToken(b, "audio");
    if (!r) r = consumeToken(b, "video");
    if (!r) r = consumeToken(b, "application");
    if (!r) r = extension_token(b, l + 1);
    exit_section_(b, l, m, DISCRETE_TYPE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // alphadigit | alphadigit *[ alphadigit | "-" ] alphadigit
  public static boolean domainlabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "domainlabel")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<domainlabel>");
    r = alphadigit(b, l + 1);
    if (!r) r = domainlabel_1(b, l + 1);
    exit_section_(b, l, m, DOMAINLABEL, r, false, null);
    return r;
  }

  // alphadigit *[ alphadigit | "-" ] alphadigit
  private static boolean domainlabel_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "domainlabel_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = domainlabel_1_0(b, l + 1);
    r = r && domainlabel_1_1(b, l + 1);
    r = r && alphadigit(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // alphadigit *
  private static boolean domainlabel_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "domainlabel_1_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!alphadigit(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "domainlabel_1_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // [ alphadigit | "-" ]
  private static boolean domainlabel_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "domainlabel_1_1")) return false;
    domainlabel_1_1_0(b, l + 1);
    return true;
  }

  // alphadigit | "-"
  private static boolean domainlabel_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "domainlabel_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = alphadigit(b, l + 1);
    if (!r) r = consumeToken(b, "-");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "\r\n" | "\r" | "\n"
  public static boolean end_of_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "end_of_line")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<end of line>");
    r = consumeToken(b, "\r\n");
    if (!r) r = consumeToken(b, "\r");
    if (!r) r = consumeToken(b, "\n");
    exit_section_(b, l, m, END_OF_LINE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "%" hex hex
  public static boolean escape(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "escape")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<escape>");
    r = consumeToken(b, "%");
    r = r && hex(b, l + 1);
    r = r && hex(b, l + 1);
    exit_section_(b, l, m, ESCAPE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ietf_token | x_token
  public static boolean extension_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extension_token")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<extension token>");
    r = ietf_token(b, l + 1);
    if (!r) r = x_token(b, l + 1);
    exit_section_(b, l, m, EXTENSION_TOKEN, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "!" | "*" | "'" | "(" | ")" | ","
  public static boolean extra(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extra")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<extra>");
    r = consumeToken(b, "!");
    if (!r) r = consumeToken(b, "*");
    if (!r) r = consumeToken(b, "'");
    if (!r) r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, ")");
    if (!r) r = consumeToken(b, ",");
    exit_section_(b, l, m, EXTRA, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // scheme ":" schemepart
  public static boolean genericurl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericurl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<genericurl>");
    r = scheme(b, l + 1);
    r = r && consumeToken(b, ":");
    r = r && schemepart(b, l + 1);
    exit_section_(b, l, m, GENERICURL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // digit | "A" | "B" | "C" | "D" | "E" | "F" |
  //                  "a" | "b" | "c" | "d" | "e" | "f"
  public static boolean hex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hex")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<hex>");
    r = digit(b, l + 1);
    if (!r) r = consumeToken(b, "A");
    if (!r) r = consumeToken(b, "B");
    if (!r) r = consumeToken(b, "C");
    if (!r) r = consumeToken(b, "D");
    if (!r) r = consumeToken(b, "E");
    if (!r) r = consumeToken(b, "F");
    if (!r) r = consumeToken(b, "a");
    if (!r) r = consumeToken(b, "b");
    if (!r) r = consumeToken(b, "c");
    if (!r) r = consumeToken(b, "d");
    if (!r) r = consumeToken(b, "e");
    if (!r) r = consumeToken(b, "f");
    exit_section_(b, l, m, HEX, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "A" | "B" | "C" | "D" | "E" | "F" | "G" | "H" | "I" |
  //                  "J" | "K" | "L" | "M" | "N" | "O" | "P" | "Q" | "R" |
  //                  "S" | "T" | "U" | "V" | "W" | "X" | "Y" | "Z"
  public static boolean hialpha(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hialpha")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<hialpha>");
    r = consumeToken(b, "A");
    if (!r) r = consumeToken(b, "B");
    if (!r) r = consumeToken(b, "C");
    if (!r) r = consumeToken(b, "D");
    if (!r) r = consumeToken(b, "E");
    if (!r) r = consumeToken(b, "F");
    if (!r) r = consumeToken(b, "G");
    if (!r) r = consumeToken(b, "H");
    if (!r) r = consumeToken(b, "I");
    if (!r) r = consumeToken(b, "J");
    if (!r) r = consumeToken(b, "K");
    if (!r) r = consumeToken(b, "L");
    if (!r) r = consumeToken(b, "M");
    if (!r) r = consumeToken(b, "N");
    if (!r) r = consumeToken(b, "O");
    if (!r) r = consumeToken(b, "P");
    if (!r) r = consumeToken(b, "Q");
    if (!r) r = consumeToken(b, "R");
    if (!r) r = consumeToken(b, "S");
    if (!r) r = consumeToken(b, "T");
    if (!r) r = consumeToken(b, "U");
    if (!r) r = consumeToken(b, "V");
    if (!r) r = consumeToken(b, "W");
    if (!r) r = consumeToken(b, "X");
    if (!r) r = consumeToken(b, "Y");
    if (!r) r = consumeToken(b, "Z");
    exit_section_(b, l, m, HIALPHA, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // hostname | hostnumber
  public static boolean host(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "host")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<host>");
    r = hostname(b, l + 1);
    if (!r) r = hostnumber(b, l + 1);
    exit_section_(b, l, m, HOST, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // *
  public static boolean hostname(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, HOSTNAME, true);
    return true;
  }

  /* ********************************************************** */
  // digits "." digits "." digits "." digits
  public static boolean hostnumber(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hostnumber")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<hostnumber>");
    r = digits(b, l + 1);
    r = r && consumeToken(b, ".");
    r = r && digits(b, l + 1);
    r = r && consumeToken(b, ".");
    r = r && digits(b, l + 1);
    r = r && consumeToken(b, ".");
    r = r && digits(b, l + 1);
    exit_section_(b, l, m, HOSTNUMBER, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // host [ ":" port ]
  public static boolean hostport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hostport")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<hostport>");
    r = host(b, l + 1);
    r = r && hostport_1(b, l + 1);
    exit_section_(b, l, m, HOSTPORT, r, false, null);
    return r;
  }

  // [ ":" port ]
  private static boolean hostport_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hostport_1")) return false;
    hostport_1_0(b, l + 1);
    return true;
  }

  // ":" port
  private static boolean hostport_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hostport_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && port(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // hsegment *[ "/" hsegment ]
  public static boolean hpath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hpath")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<hpath>");
    r = hpath_0(b, l + 1);
    r = r && hpath_1(b, l + 1);
    exit_section_(b, l, m, HPATH, r, false, null);
    return r;
  }

  // hsegment *
  private static boolean hpath_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hpath_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!hsegment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "hpath_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // [ "/" hsegment ]
  private static boolean hpath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hpath_1")) return false;
    hpath_1_0(b, l + 1);
    return true;
  }

  // "/" hsegment
  private static boolean hpath_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hpath_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "/");
    r = r && hsegment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // *
  public static boolean hsegment(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, HSEGMENT, true);
    return true;
  }

  /* ********************************************************** */
  // "https://" hostport [ "/" hpath [ "?" search ]]
  public static boolean httpsurl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "httpsurl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<httpsurl>");
    r = consumeToken(b, "https://");
    r = r && hostport(b, l + 1);
    r = r && httpsurl_2(b, l + 1);
    exit_section_(b, l, m, HTTPSURL, r, false, null);
    return r;
  }

  // [ "/" hpath [ "?" search ]]
  private static boolean httpsurl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "httpsurl_2")) return false;
    httpsurl_2_0(b, l + 1);
    return true;
  }

  // "/" hpath [ "?" search ]
  private static boolean httpsurl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "httpsurl_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "/");
    r = r && hpath(b, l + 1);
    r = r && httpsurl_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ "?" search ]
  private static boolean httpsurl_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "httpsurl_2_0_2")) return false;
    httpsurl_2_0_2_0(b, l + 1);
    return true;
  }

  // "?" search
  private static boolean httpsurl_2_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "httpsurl_2_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "?");
    r = r && search(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "http://" hostport [ "/" hpath [ "?" search ]]
  public static boolean httpurl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "httpurl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<httpurl>");
    r = consumeToken(b, "http://");
    r = r && hostport(b, l + 1);
    r = r && httpurl_2(b, l + 1);
    exit_section_(b, l, m, HTTPURL, r, false, null);
    return r;
  }

  // [ "/" hpath [ "?" search ]]
  private static boolean httpurl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "httpurl_2")) return false;
    httpurl_2_0(b, l + 1);
    return true;
  }

  // "/" hpath [ "?" search ]
  private static boolean httpurl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "httpurl_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "/");
    r = r && hpath(b, l + 1);
    r = r && httpurl_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ "?" search ]
  private static boolean httpurl_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "httpurl_2_0_2")) return false;
    httpurl_2_0_2_0(b, l + 1);
    return true;
  }

  // "?" search
  private static boolean httpurl_2_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "httpurl_2_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "?");
    r = r && search(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // token
  public static boolean iana_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iana_token")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<iana token>");
    r = token(b, l + 1);
    exit_section_(b, l, m, IANA_TOKEN, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // token
  public static boolean ietf_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ietf_token")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<ietf token>");
    r = token(b, l + 1);
    exit_section_(b, l, m, IETF_TOKEN, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // whitespace | whitespace in_line_whitespace
  public static boolean in_line_whitespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "in_line_whitespace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<in line whitespace>");
    r = whitespace(b, l + 1);
    if (!r) r = in_line_whitespace_1(b, l + 1);
    exit_section_(b, l, m, IN_LINE_WHITESPACE, r, false, null);
    return r;
  }

  // whitespace in_line_whitespace
  private static boolean in_line_whitespace_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "in_line_whitespace_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = whitespace(b, l + 1);
    r = r && in_line_whitespace(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // digit | digit integer_number
  public static boolean integer_number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<integer number>");
    r = digit(b, l + 1);
    if (!r) r = integer_number_1(b, l + 1);
    exit_section_(b, l, m, INTEGER_NUMBER, r, false, null);
    return r;
  }

  // digit integer_number
  private static boolean integer_number_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_number_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = digit(b, l + 1);
    r = r && integer_number(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "//" login [ "/" urlpath ]
  public static boolean ip_schemepart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ip_schemepart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<ip schemepart>");
    r = consumeToken(b, "//");
    r = r && login(b, l + 1);
    r = r && ip_schemepart_2(b, l + 1);
    exit_section_(b, l, m, IP_SCHEMEPART, r, false, null);
    return r;
  }

  // [ "/" urlpath ]
  private static boolean ip_schemepart_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ip_schemepart_2")) return false;
    ip_schemepart_2_0(b, l + 1);
    return true;
  }

  // "/" urlpath
  private static boolean ip_schemepart_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ip_schemepart_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "/");
    r = r && urlpath(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // [ user [ ":" password ] "@" ] hostport
  public static boolean login(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "login")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<login>");
    r = login_0(b, l + 1);
    r = r && hostport(b, l + 1);
    exit_section_(b, l, m, LOGIN, r, false, null);
    return r;
  }

  // [ user [ ":" password ] "@" ]
  private static boolean login_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "login_0")) return false;
    login_0_0(b, l + 1);
    return true;
  }

  // user [ ":" password ] "@"
  private static boolean login_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "login_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = user(b, l + 1);
    r = r && login_0_0_1(b, l + 1);
    r = r && consumeToken(b, "@");
    exit_section_(b, m, null, r);
    return r;
  }

  // [ ":" password ]
  private static boolean login_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "login_0_0_1")) return false;
    login_0_0_1_0(b, l + 1);
    return true;
  }

  // ":" password
  private static boolean login_0_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "login_0_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ":");
    r = r && password(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "a" | "b" | "c" | "d" | "e" | "f" | "g" | "h" |
  //                  "i" | "j" | "k" | "l" | "m" | "n" | "o" | "p" |
  //                  "q" | "r" | "s" | "t" | "u" | "v" | "w" | "x" |
  //                  "y" | "z"
  public static boolean lowalpha(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lowalpha")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<lowalpha>");
    r = consumeToken(b, "a");
    if (!r) r = consumeToken(b, "b");
    if (!r) r = consumeToken(b, "c");
    if (!r) r = consumeToken(b, "d");
    if (!r) r = consumeToken(b, "e");
    if (!r) r = consumeToken(b, "f");
    if (!r) r = consumeToken(b, "g");
    if (!r) r = consumeToken(b, "h");
    if (!r) r = consumeToken(b, "i");
    if (!r) r = consumeToken(b, "j");
    if (!r) r = consumeToken(b, "k");
    if (!r) r = consumeToken(b, "l");
    if (!r) r = consumeToken(b, "m");
    if (!r) r = consumeToken(b, "n");
    if (!r) r = consumeToken(b, "o");
    if (!r) r = consumeToken(b, "p");
    if (!r) r = consumeToken(b, "q");
    if (!r) r = consumeToken(b, "r");
    if (!r) r = consumeToken(b, "s");
    if (!r) r = consumeToken(b, "t");
    if (!r) r = consumeToken(b, "u");
    if (!r) r = consumeToken(b, "v");
    if (!r) r = consumeToken(b, "w");
    if (!r) r = consumeToken(b, "x");
    if (!r) r = consumeToken(b, "y");
    if (!r) r = consumeToken(b, "z");
    exit_section_(b, l, m, LOWALPHA, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // type "/" subtype
  //                 *(";" parameter)
  public static boolean mimetype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mimetype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<mimetype>");
    r = type(b, l + 1);
    r = r && consumeToken(b, "/");
    r = r && mimetype_2(b, l + 1);
    r = r && mimetype_3(b, l + 1);
    exit_section_(b, l, m, MIMETYPE, r, false, null);
    return r;
  }

  // subtype
  //                 *
  private static boolean mimetype_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mimetype_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!subtype(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mimetype_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ";" parameter
  private static boolean mimetype_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mimetype_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ";");
    r = r && parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "{" | "}" | "|" | "\\" | "^" | "~" | "[" | "]" | "`"
  public static boolean national(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "national")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<national>");
    r = consumeToken(b, "{");
    if (!r) r = consumeToken(b, "}");
    if (!r) r = consumeToken(b, "|");
    if (!r) r = consumeToken(b, "\\");
    if (!r) r = consumeToken(b, "^");
    if (!r) r = consumeToken(b, "~");
    if (!r) r = consumeToken(b, "[");
    if (!r) r = consumeToken(b, "]");
    if (!r) r = consumeToken(b, "`");
    exit_section_(b, l, m, NATIONAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  public static boolean non_whitespace(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, NON_WHITESPACE, true);
    return true;
  }

  /* ********************************************************** */
  // non_whitespace | non_whitespace non_whitespace_word
  public static boolean non_whitespace_word(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_whitespace_word")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<non whitespace word>");
    r = non_whitespace(b, l + 1);
    if (!r) r = non_whitespace_word_1(b, l + 1);
    exit_section_(b, l, m, NON_WHITESPACE_WORD, r, false, null);
    return r;
  }

  // non_whitespace non_whitespace_word
  private static boolean non_whitespace_word_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_whitespace_word_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = non_whitespace(b, l + 1);
    r = r && non_whitespace_word(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // genericurl
  public static boolean otherurl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "otherurl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<otherurl>");
    r = genericurl(b, l + 1);
    exit_section_(b, l, m, OTHERURL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // attribute "=" value
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<parameter>");
    r = attribute(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && value(b, l + 1);
    exit_section_(b, l, m, PARAMETER, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // *
  public static boolean password(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, PASSWORD, true);
    return true;
  }

  /* ********************************************************** */
  // digits
  public static boolean port(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "port")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<port>");
    r = digits(b, l + 1);
    exit_section_(b, l, m, PORT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "<" | ">" | "#" | "%"
  public static boolean punctuation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "punctuation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<punctuation>");
    r = consumeToken(b, "<");
    if (!r) r = consumeToken(b, ">");
    if (!r) r = consumeToken(b, "#");
    if (!r) r = consumeToken(b, "%");
    exit_section_(b, l, m, PUNCTUATION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "baseUri:" url
  public static boolean raml_base_uri(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_base_uri")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml base uri>");
    r = consumeToken(b, "baseUri:");
    r = r && url(b, l + 1);
    exit_section_(b, l, m, RAML_BASE_URI, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "#" *xchar
  public static boolean raml_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_comment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml comment>");
    r = raml_comment_0(b, l + 1);
    r = r && xchar(b, l + 1);
    exit_section_(b, l, m, RAML_COMMENT, r, false, null);
    return r;
  }

  // "#" *
  private static boolean raml_comment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_comment_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, "#")) break;
      if (!empty_element_parsed_guard_(b, "raml_comment_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // [raml_title] [raml_base_uri] [raml_version] [raml_secured_by] [raml_security_schemes] [raml_resource_types] [raml_traits] [raml_media_type] [raml_schemas] [*raml_resource]
  public static boolean raml_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml content>");
    r = raml_content_0(b, l + 1);
    r = r && raml_content_1(b, l + 1);
    r = r && raml_content_2(b, l + 1);
    r = r && raml_content_3(b, l + 1);
    r = r && raml_content_4(b, l + 1);
    r = r && raml_content_5(b, l + 1);
    r = r && raml_content_6(b, l + 1);
    r = r && raml_content_7(b, l + 1);
    r = r && raml_content_8(b, l + 1);
    r = r && raml_content_9(b, l + 1);
    exit_section_(b, l, m, RAML_CONTENT, r, false, null);
    return r;
  }

  // [raml_title]
  private static boolean raml_content_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_0")) return false;
    raml_title(b, l + 1);
    return true;
  }

  // [raml_base_uri]
  private static boolean raml_content_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_1")) return false;
    raml_base_uri(b, l + 1);
    return true;
  }

  // [raml_version]
  private static boolean raml_content_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_2")) return false;
    raml_version(b, l + 1);
    return true;
  }

  // [raml_secured_by]
  private static boolean raml_content_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_3")) return false;
    raml_secured_by(b, l + 1);
    return true;
  }

  // [raml_security_schemes]
  private static boolean raml_content_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_4")) return false;
    raml_security_schemes(b, l + 1);
    return true;
  }

  // [raml_resource_types]
  private static boolean raml_content_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_5")) return false;
    raml_resource_types(b, l + 1);
    return true;
  }

  // [raml_traits]
  private static boolean raml_content_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_6")) return false;
    raml_traits(b, l + 1);
    return true;
  }

  // [raml_media_type]
  private static boolean raml_content_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_7")) return false;
    raml_media_type(b, l + 1);
    return true;
  }

  // [raml_schemas]
  private static boolean raml_content_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_8")) return false;
    raml_schemas(b, l + 1);
    return true;
  }

  // [*raml_resource]
  private static boolean raml_content_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_9")) return false;
    consumeToken(b, RAML_CONTENT_9_0_0);
    return true;
  }

  /* ********************************************************** */
  // raml_content raml_content_list | raml_content end_of_line
  public static boolean raml_content_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml content list>");
    r = raml_content_list_0(b, l + 1);
    if (!r) r = raml_content_list_1(b, l + 1);
    exit_section_(b, l, m, RAML_CONTENT_LIST, r, false, null);
    return r;
  }

  // raml_content raml_content_list
  private static boolean raml_content_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = raml_content(b, l + 1);
    r = r && raml_content_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // raml_content end_of_line
  private static boolean raml_content_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_content_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = raml_content(b, l + 1);
    r = r && end_of_line(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // raml_directive_raml | raml_directive_tag
  public static boolean raml_directive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_directive")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml directive>");
    r = raml_directive_raml(b, l + 1);
    if (!r) r = raml_directive_tag(b, l + 1);
    exit_section_(b, l, m, RAML_DIRECTIVE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // raml_directive raml_directive_list | ""
  public static boolean raml_directive_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_directive_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml directive list>");
    r = raml_directive_list_0(b, l + 1);
    if (!r) r = consumeToken(b, "");
    exit_section_(b, l, m, RAML_DIRECTIVE_LIST, r, false, null);
    return r;
  }

  // raml_directive raml_directive_list
  private static boolean raml_directive_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_directive_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = raml_directive(b, l + 1);
    r = r && raml_directive_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "%RAML" in_line_whitespace integer_number "." integer_number end_of_line | ""
  public static boolean raml_directive_raml(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_directive_raml")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml directive raml>");
    r = raml_directive_raml_0(b, l + 1);
    if (!r) r = consumeToken(b, "");
    exit_section_(b, l, m, RAML_DIRECTIVE_RAML, r, false, null);
    return r;
  }

  // "%RAML" in_line_whitespace integer_number "." integer_number end_of_line
  private static boolean raml_directive_raml_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_directive_raml_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "%RAML");
    r = r && in_line_whitespace(b, l + 1);
    r = r && integer_number(b, l + 1);
    r = r && consumeToken(b, ".");
    r = r && integer_number(b, l + 1);
    r = r && end_of_line(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "%TAG" in_line_whitespace raml_tag_handle in_line_whitespace raml_tag_prefix end_of_line raml_directive_tag | ""
  public static boolean raml_directive_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_directive_tag")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml directive tag>");
    r = raml_directive_tag_0(b, l + 1);
    if (!r) r = consumeToken(b, "");
    exit_section_(b, l, m, RAML_DIRECTIVE_TAG, r, false, null);
    return r;
  }

  // "%TAG" in_line_whitespace raml_tag_handle in_line_whitespace raml_tag_prefix end_of_line raml_directive_tag
  private static boolean raml_directive_tag_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_directive_tag_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "%TAG");
    r = r && in_line_whitespace(b, l + 1);
    r = r && raml_tag_handle(b, l + 1);
    r = r && in_line_whitespace(b, l + 1);
    r = r && raml_tag_prefix(b, l + 1);
    r = r && end_of_line(b, l + 1);
    r = r && raml_directive_tag(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // raml_directive_list raml_directives_end raml_content_list raml_document_end
  public static boolean raml_document(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_document")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml document>");
    r = raml_directive_list(b, l + 1);
    r = r && consumeToken(b, RAML_DIRECTIVES_END);
    r = r && raml_content_list(b, l + 1);
    r = r && raml_document_end(b, l + 1);
    exit_section_(b, l, m, RAML_DOCUMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "..." | ""
  public static boolean raml_document_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_document_end")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml document end>");
    r = consumeToken(b, "...");
    if (!r) r = consumeToken(b, "");
    exit_section_(b, l, m, RAML_DOCUMENT_END, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // raml_document | raml_document raml_document_list
  public static boolean raml_document_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_document_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml document list>");
    r = raml_document(b, l + 1);
    if (!r) r = raml_document_list_1(b, l + 1);
    exit_section_(b, l, m, RAML_DOCUMENT_LIST, r, false, null);
    return r;
  }

  // raml_document raml_document_list
  private static boolean raml_document_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_document_list_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = raml_document(b, l + 1);
    r = r && raml_document_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "---" | ""
  public static boolean raml_irectives_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_irectives_end")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml irectives end>");
    r = consumeToken(b, "---");
    if (!r) r = consumeToken(b, "");
    exit_section_(b, l, m, RAML_IRECTIVES_END, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "mediaType:" mimetype
  public static boolean raml_media_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_media_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml media type>");
    r = consumeToken(b, "mediaType:");
    r = r && mimetype(b, l + 1);
    exit_section_(b, l, m, RAML_MEDIA_TYPE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // hpath
  public static boolean raml_resource(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_resource")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml resource>");
    r = hpath(b, l + 1);
    exit_section_(b, l, m, RAML_RESOURCE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "resourceTypes:"
  public static boolean raml_resource_types(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_resource_types")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml resource types>");
    r = consumeToken(b, "resourceTypes:");
    exit_section_(b, l, m, RAML_RESOURCE_TYPES, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "schemas:"
  public static boolean raml_schemas(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_schemas")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml schemas>");
    r = consumeToken(b, "schemas:");
    exit_section_(b, l, m, RAML_SCHEMAS, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "securedBy:" "[" *xchar [{"," *xchar}] "]"
  public static boolean raml_secured_by(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_secured_by")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml secured by>");
    r = consumeToken(b, "securedBy:");
    r = r && raml_secured_by_1(b, l + 1);
    r = r && xchar(b, l + 1);
    r = r && raml_secured_by_3(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, l, m, RAML_SECURED_BY, r, false, null);
    return r;
  }

  // "[" *
  private static boolean raml_secured_by_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_secured_by_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, "[")) break;
      if (!empty_element_parsed_guard_(b, "raml_secured_by_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // [{"," *xchar}]
  private static boolean raml_secured_by_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_secured_by_3")) return false;
    raml_secured_by_3_0(b, l + 1);
    return true;
  }

  // "," *xchar
  private static boolean raml_secured_by_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_secured_by_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = raml_secured_by_3_0_0(b, l + 1);
    r = r && xchar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "," *
  private static boolean raml_secured_by_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_secured_by_3_0_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, ",")) break;
      if (!empty_element_parsed_guard_(b, "raml_secured_by_3_0_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // "securitySchemes:"
  public static boolean raml_security_schemes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_security_schemes")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml security schemes>");
    r = consumeToken(b, "securitySchemes:");
    exit_section_(b, l, m, RAML_SECURITY_SCHEMES, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // raml_document_list
  public static boolean raml_stream(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_stream")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml stream>");
    r = raml_document_list(b, l + 1);
    exit_section_(b, l, m, RAML_STREAM, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "!" | "!!" | "!" non_whitespace_word "!"
  public static boolean raml_tag_handle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_tag_handle")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml tag handle>");
    r = consumeToken(b, "!");
    if (!r) r = consumeToken(b, "!!");
    if (!r) r = raml_tag_handle_2(b, l + 1);
    exit_section_(b, l, m, RAML_TAG_HANDLE, r, false, null);
    return r;
  }

  // "!" non_whitespace_word "!"
  private static boolean raml_tag_handle_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_tag_handle_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "!");
    r = r && non_whitespace_word(b, l + 1);
    r = r && consumeToken(b, "!");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "!" non_whitespace_word | non_whitespace_word
  public static boolean raml_tag_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_tag_prefix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml tag prefix>");
    r = raml_tag_prefix_0(b, l + 1);
    if (!r) r = non_whitespace_word(b, l + 1);
    exit_section_(b, l, m, RAML_TAG_PREFIX, r, false, null);
    return r;
  }

  // "!" non_whitespace_word
  private static boolean raml_tag_prefix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_tag_prefix_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "!");
    r = r && non_whitespace_word(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "title:" *xchar
  public static boolean raml_title(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_title")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml title>");
    r = raml_title_0(b, l + 1);
    r = r && xchar(b, l + 1);
    exit_section_(b, l, m, RAML_TITLE, r, false, null);
    return r;
  }

  // "title:" *
  private static boolean raml_title_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_title_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, "title:")) break;
      if (!empty_element_parsed_guard_(b, "raml_title_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // "traits:"
  public static boolean raml_traits(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_traits")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml traits>");
    r = consumeToken(b, "traits:");
    exit_section_(b, l, m, RAML_TRAITS, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "version:"
  public static boolean raml_version(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "raml_version")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<raml version>");
    r = consumeToken(b, "version:");
    exit_section_(b, l, m, RAML_VERSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ";" | "/" | "?" | ":" | "@" | "&" | "="
  public static boolean reserved(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reserved")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<reserved>");
    r = consumeToken(b, ";");
    if (!r) r = consumeToken(b, "/");
    if (!r) r = consumeToken(b, "?");
    if (!r) r = consumeToken(b, ":");
    if (!r) r = consumeToken(b, "@");
    if (!r) r = consumeToken(b, "&");
    if (!r) r = consumeToken(b, "=");
    exit_section_(b, l, m, RESERVED, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "$" | "-" | "_" | "." | "+"
  public static boolean safe(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "safe")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<safe>");
    r = consumeToken(b, "$");
    if (!r) r = consumeToken(b, "-");
    if (!r) r = consumeToken(b, "_");
    if (!r) r = consumeToken(b, ".");
    if (!r) r = consumeToken(b, "+");
    exit_section_(b, l, m, SAFE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 1*[ lowalpha | digit | "+" | "-" | "." ]
  public static boolean scheme(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<scheme>");
    r = scheme_0(b, l + 1);
    r = r && scheme_1(b, l + 1);
    exit_section_(b, l, m, SCHEME, r, false, null);
    return r;
  }

  // 1*
  private static boolean scheme_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, "1")) break;
      if (!empty_element_parsed_guard_(b, "scheme_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // [ lowalpha | digit | "+" | "-" | "." ]
  private static boolean scheme_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme_1")) return false;
    scheme_1_0(b, l + 1);
    return true;
  }

  // lowalpha | digit | "+" | "-" | "."
  private static boolean scheme_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lowalpha(b, l + 1);
    if (!r) r = digit(b, l + 1);
    if (!r) r = consumeToken(b, "+");
    if (!r) r = consumeToken(b, "-");
    if (!r) r = consumeToken(b, ".");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // *xchar | ip_schemepart
  public static boolean schemepart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemepart")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<schemepart>");
    r = consumeToken(b, SCHEMEPART_0_0);
    if (!r) r = ip_schemepart(b, l + 1);
    exit_section_(b, l, m, SCHEMEPART, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // *
  public static boolean search(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, SEARCH, true);
    return true;
  }

  /* ********************************************************** */
  // extension_token | iana_token
  public static boolean subtype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subtype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<subtype>");
    r = extension_token(b, l + 1);
    if (!r) r = iana_token(b, l + 1);
    exit_section_(b, l, m, SUBTYPE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 1*unreserved
  public static boolean token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "token")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<token>");
    r = token_0(b, l + 1);
    r = r && unreserved(b, l + 1);
    exit_section_(b, l, m, TOKEN, r, false, null);
    return r;
  }

  // 1*
  private static boolean token_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "token_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, "1")) break;
      if (!empty_element_parsed_guard_(b, "token_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // alpha | alpha *[ alphadigit | "-" ] alphadigit
  public static boolean toplabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "toplabel")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<toplabel>");
    r = alpha(b, l + 1);
    if (!r) r = toplabel_1(b, l + 1);
    exit_section_(b, l, m, TOPLABEL, r, false, null);
    return r;
  }

  // alpha *[ alphadigit | "-" ] alphadigit
  private static boolean toplabel_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "toplabel_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = toplabel_1_0(b, l + 1);
    r = r && toplabel_1_1(b, l + 1);
    r = r && alphadigit(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // alpha *
  private static boolean toplabel_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "toplabel_1_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!alpha(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "toplabel_1_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // [ alphadigit | "-" ]
  private static boolean toplabel_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "toplabel_1_1")) return false;
    toplabel_1_1_0(b, l + 1);
    return true;
  }

  // alphadigit | "-"
  private static boolean toplabel_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "toplabel_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = alphadigit(b, l + 1);
    if (!r) r = consumeToken(b, "-");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "(" | ")" | "<" | ">" | "@" |
  //            "," | ";" | ":" | "\\" |
  //            "/" | "[" | "]" | "?" | "="
  public static boolean tspecials(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tspecials")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<tspecials>");
    r = consumeToken(b, "(");
    if (!r) r = consumeToken(b, ")");
    if (!r) r = consumeToken(b, "<");
    if (!r) r = consumeToken(b, ">");
    if (!r) r = consumeToken(b, "@");
    if (!r) r = consumeToken(b, ",");
    if (!r) r = consumeToken(b, ";");
    if (!r) r = consumeToken(b, ":");
    if (!r) r = consumeToken(b, "\\");
    if (!r) r = consumeToken(b, "/");
    if (!r) r = consumeToken(b, "[");
    if (!r) r = consumeToken(b, "]");
    if (!r) r = consumeToken(b, "?");
    if (!r) r = consumeToken(b, "=");
    exit_section_(b, l, m, TSPECIALS, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // discrete_type | composite_type
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<type>");
    r = discrete_type(b, l + 1);
    if (!r) r = composite_type(b, l + 1);
    exit_section_(b, l, m, TYPE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // unreserved | escape
  public static boolean uchar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "uchar")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<uchar>");
    r = unreserved(b, l + 1);
    if (!r) r = escape(b, l + 1);
    exit_section_(b, l, m, UCHAR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // alpha | digit | safe | extra
  public static boolean unreserved(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unreserved")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<unreserved>");
    r = alpha(b, l + 1);
    if (!r) r = digit(b, l + 1);
    if (!r) r = safe(b, l + 1);
    if (!r) r = extra(b, l + 1);
    exit_section_(b, l, m, UNRESERVED, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // httpurl | httpsurl | otherurl
  public static boolean url(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<url>");
    r = httpurl(b, l + 1);
    if (!r) r = httpsurl(b, l + 1);
    if (!r) r = otherurl(b, l + 1);
    exit_section_(b, l, m, URL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // *xchar
  public static boolean urlpath(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, URLPATH, true);
    return true;
  }

  /* ********************************************************** */
  // *
  public static boolean user(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, USER, true);
    return true;
  }

  /* ********************************************************** */
  // token
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<value>");
    r = token(b, l + 1);
    exit_section_(b, l, m, VALUE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // " " | "\t"
  static boolean whitespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whitespace")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, " ");
    if (!r) r = consumeToken(b, "\t");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "X-" token | "x-" token
  public static boolean x_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "x_token")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<x token>");
    r = x_token_0(b, l + 1);
    if (!r) r = x_token_1(b, l + 1);
    exit_section_(b, l, m, X_TOKEN, r, false, null);
    return r;
  }

  // "X-" token
  private static boolean x_token_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "x_token_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "X-");
    r = r && token(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "x-" token
  private static boolean x_token_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "x_token_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "x-");
    r = r && token(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unreserved | reserved | escape
  public static boolean xchar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xchar")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<xchar>");
    r = unreserved(b, l + 1);
    if (!r) r = reserved(b, l + 1);
    if (!r) r = escape(b, l + 1);
    exit_section_(b, l, m, XCHAR, r, false, null);
    return r;
  }

}
