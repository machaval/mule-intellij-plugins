// This is a generated file. Not intended for manual editing.
package org.mule.lang.raml.parser.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.mule.lang.raml.parser.RamlElementType;
import org.mule.lang.raml.parser.RamlTokenType;
import org.mule.lang.raml.parser.impl.*;

public interface RamlTypes {

  IElementType ALPHA = new RamlElementType("ALPHA");
  IElementType ALPHADIGIT = new RamlElementType("ALPHADIGIT");
  IElementType ATTRIBUTE = new RamlElementType("ATTRIBUTE");
  IElementType COMPOSITE_TYPE = new RamlElementType("COMPOSITE_TYPE");
  IElementType DIGIT = new RamlElementType("DIGIT");
  IElementType DIGITS = new RamlElementType("DIGITS");
  IElementType DISCRETE_TYPE = new RamlElementType("DISCRETE_TYPE");
  IElementType DOMAINLABEL = new RamlElementType("DOMAINLABEL");
  IElementType END_OF_LINE = new RamlElementType("END_OF_LINE");
  IElementType ESCAPE = new RamlElementType("ESCAPE");
  IElementType EXTENSION_TOKEN = new RamlElementType("EXTENSION_TOKEN");
  IElementType EXTRA = new RamlElementType("EXTRA");
  IElementType GENERICURL = new RamlElementType("GENERICURL");
  IElementType HEX = new RamlElementType("HEX");
  IElementType HIALPHA = new RamlElementType("HIALPHA");
  IElementType HOST = new RamlElementType("HOST");
  IElementType HOSTNAME = new RamlElementType("HOSTNAME");
  IElementType HOSTNUMBER = new RamlElementType("HOSTNUMBER");
  IElementType HOSTPORT = new RamlElementType("HOSTPORT");
  IElementType HPATH = new RamlElementType("HPATH");
  IElementType HSEGMENT = new RamlElementType("HSEGMENT");
  IElementType HTTPSURL = new RamlElementType("HTTPSURL");
  IElementType HTTPURL = new RamlElementType("HTTPURL");
  IElementType IANA_TOKEN = new RamlElementType("IANA_TOKEN");
  IElementType IETF_TOKEN = new RamlElementType("IETF_TOKEN");
  IElementType INTEGER_NUMBER = new RamlElementType("INTEGER_NUMBER");
  IElementType IN_LINE_WHITESPACE = new RamlElementType("IN_LINE_WHITESPACE");
  IElementType IP_SCHEMEPART = new RamlElementType("IP_SCHEMEPART");
  IElementType LOGIN = new RamlElementType("LOGIN");
  IElementType LOWALPHA = new RamlElementType("LOWALPHA");
  IElementType MIMETYPE = new RamlElementType("MIMETYPE");
  IElementType NATIONAL = new RamlElementType("NATIONAL");
  IElementType NON_WHITESPACE = new RamlElementType("NON_WHITESPACE");
  IElementType NON_WHITESPACE_WORD = new RamlElementType("NON_WHITESPACE_WORD");
  IElementType OTHERURL = new RamlElementType("OTHERURL");
  IElementType PARAMETER = new RamlElementType("PARAMETER");
  IElementType PASSWORD = new RamlElementType("PASSWORD");
  IElementType PORT = new RamlElementType("PORT");
  IElementType PUNCTUATION = new RamlElementType("PUNCTUATION");
  IElementType RAML_BASE_URI = new RamlElementType("RAML_BASE_URI");
  IElementType RAML_COMMENT = new RamlElementType("RAML_COMMENT");
  IElementType RAML_CONTENT = new RamlElementType("RAML_CONTENT");
  IElementType RAML_CONTENT_LIST = new RamlElementType("RAML_CONTENT_LIST");
  IElementType RAML_DIRECTIVE = new RamlElementType("RAML_DIRECTIVE");
  IElementType RAML_DIRECTIVE_LIST = new RamlElementType("RAML_DIRECTIVE_LIST");
  IElementType RAML_DIRECTIVE_RAML = new RamlElementType("RAML_DIRECTIVE_RAML");
  IElementType RAML_DIRECTIVE_TAG = new RamlElementType("RAML_DIRECTIVE_TAG");
  IElementType RAML_DOCUMENT = new RamlElementType("RAML_DOCUMENT");
  IElementType RAML_DOCUMENT_END = new RamlElementType("RAML_DOCUMENT_END");
  IElementType RAML_DOCUMENT_LIST = new RamlElementType("RAML_DOCUMENT_LIST");
  IElementType RAML_IRECTIVES_END = new RamlElementType("RAML_IRECTIVES_END");
  IElementType RAML_MEDIA_TYPE = new RamlElementType("RAML_MEDIA_TYPE");
  IElementType RAML_RESOURCE = new RamlElementType("RAML_RESOURCE");
  IElementType RAML_RESOURCE_TYPES = new RamlElementType("RAML_RESOURCE_TYPES");
  IElementType RAML_SCHEMAS = new RamlElementType("RAML_SCHEMAS");
  IElementType RAML_SECURED_BY = new RamlElementType("RAML_SECURED_BY");
  IElementType RAML_SECURITY_SCHEMES = new RamlElementType("RAML_SECURITY_SCHEMES");
  IElementType RAML_STREAM = new RamlElementType("RAML_STREAM");
  IElementType RAML_TAG_HANDLE = new RamlElementType("RAML_TAG_HANDLE");
  IElementType RAML_TAG_PREFIX = new RamlElementType("RAML_TAG_PREFIX");
  IElementType RAML_TITLE = new RamlElementType("RAML_TITLE");
  IElementType RAML_TRAITS = new RamlElementType("RAML_TRAITS");
  IElementType RAML_VERSION = new RamlElementType("RAML_VERSION");
  IElementType RESERVED = new RamlElementType("RESERVED");
  IElementType SAFE = new RamlElementType("SAFE");
  IElementType SCHEME = new RamlElementType("SCHEME");
  IElementType SCHEMEPART = new RamlElementType("SCHEMEPART");
  IElementType SEARCH = new RamlElementType("SEARCH");
  IElementType SUBTYPE = new RamlElementType("SUBTYPE");
  IElementType TOKEN = new RamlElementType("TOKEN");
  IElementType TOPLABEL = new RamlElementType("TOPLABEL");
  IElementType TSPECIALS = new RamlElementType("TSPECIALS");
  IElementType TYPE = new RamlElementType("TYPE");
  IElementType UCHAR = new RamlElementType("UCHAR");
  IElementType UNRESERVED = new RamlElementType("UNRESERVED");
  IElementType URL = new RamlElementType("URL");
  IElementType URLPATH = new RamlElementType("URLPATH");
  IElementType USER = new RamlElementType("USER");
  IElementType VALUE = new RamlElementType("VALUE");
  IElementType XCHAR = new RamlElementType("XCHAR");
  IElementType X_TOKEN = new RamlElementType("X_TOKEN");

  IElementType RAML_CONTENT_9_0_0 = new RamlTokenType("raml_content_9_0_0");
  IElementType RAML_DIRECTIVES_END = new RamlTokenType("raml_directives_end");
  IElementType SCHEMEPART_0_0 = new RamlTokenType("schemepart_0_0");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ALPHA) {
        return new RamlAlphaImpl(node);
      }
      else if (type == ALPHADIGIT) {
        return new RamlAlphadigitImpl(node);
      }
      else if (type == ATTRIBUTE) {
        return new RamlAttributeImpl(node);
      }
      else if (type == COMPOSITE_TYPE) {
        return new RamlCompositeTypeImpl(node);
      }
      else if (type == DIGIT) {
        return new RamlDigitImpl(node);
      }
      else if (type == DIGITS) {
        return new RamlDigitsImpl(node);
      }
      else if (type == DISCRETE_TYPE) {
        return new RamlDiscreteTypeImpl(node);
      }
      else if (type == DOMAINLABEL) {
        return new RamlDomainlabelImpl(node);
      }
      else if (type == END_OF_LINE) {
        return new RamlEndOfLineImpl(node);
      }
      else if (type == ESCAPE) {
        return new RamlEscapeImpl(node);
      }
      else if (type == EXTENSION_TOKEN) {
        return new RamlExtensionTokenImpl(node);
      }
      else if (type == EXTRA) {
        return new RamlExtraImpl(node);
      }
      else if (type == GENERICURL) {
        return new RamlGenericurlImpl(node);
      }
      else if (type == HEX) {
        return new RamlHexImpl(node);
      }
      else if (type == HIALPHA) {
        return new RamlHialphaImpl(node);
      }
      else if (type == HOST) {
        return new RamlHostImpl(node);
      }
      else if (type == HOSTNAME) {
        return new RamlHostnameImpl(node);
      }
      else if (type == HOSTNUMBER) {
        return new RamlHostnumberImpl(node);
      }
      else if (type == HOSTPORT) {
        return new RamlHostportImpl(node);
      }
      else if (type == HPATH) {
        return new RamlHpathImpl(node);
      }
      else if (type == HSEGMENT) {
        return new RamlHsegmentImpl(node);
      }
      else if (type == HTTPSURL) {
        return new RamlHttpsurlImpl(node);
      }
      else if (type == HTTPURL) {
        return new RamlHttpurlImpl(node);
      }
      else if (type == IANA_TOKEN) {
        return new RamlIanaTokenImpl(node);
      }
      else if (type == IETF_TOKEN) {
        return new RamlIetfTokenImpl(node);
      }
      else if (type == INTEGER_NUMBER) {
        return new RamlIntegerNumberImpl(node);
      }
      else if (type == IN_LINE_WHITESPACE) {
        return new RamlInLineWhitespaceImpl(node);
      }
      else if (type == IP_SCHEMEPART) {
        return new RamlIpSchemepartImpl(node);
      }
      else if (type == LOGIN) {
        return new RamlLoginImpl(node);
      }
      else if (type == LOWALPHA) {
        return new RamlLowalphaImpl(node);
      }
      else if (type == MIMETYPE) {
        return new RamlMimetypeImpl(node);
      }
      else if (type == NATIONAL) {
        return new RamlNationalImpl(node);
      }
      else if (type == NON_WHITESPACE) {
        return new RamlNonWhitespaceImpl(node);
      }
      else if (type == NON_WHITESPACE_WORD) {
        return new RamlNonWhitespaceWordImpl(node);
      }
      else if (type == OTHERURL) {
        return new RamlOtherurlImpl(node);
      }
      else if (type == PARAMETER) {
        return new RamlParameterImpl(node);
      }
      else if (type == PASSWORD) {
        return new RamlPasswordImpl(node);
      }
      else if (type == PORT) {
        return new RamlPortImpl(node);
      }
      else if (type == PUNCTUATION) {
        return new RamlPunctuationImpl(node);
      }
      else if (type == RAML_BASE_URI) {
        return new RamlRamlBaseUriImpl(node);
      }
      else if (type == RAML_COMMENT) {
        return new RamlRamlCommentImpl(node);
      }
      else if (type == RAML_CONTENT) {
        return new RamlRamlContentImpl(node);
      }
      else if (type == RAML_CONTENT_LIST) {
        return new RamlRamlContentListImpl(node);
      }
      else if (type == RAML_DIRECTIVE) {
        return new RamlRamlDirectiveImpl(node);
      }
      else if (type == RAML_DIRECTIVE_LIST) {
        return new RamlRamlDirectiveListImpl(node);
      }
      else if (type == RAML_DIRECTIVE_RAML) {
        return new RamlRamlDirectiveRamlImpl(node);
      }
      else if (type == RAML_DIRECTIVE_TAG) {
        return new RamlRamlDirectiveTagImpl(node);
      }
      else if (type == RAML_DOCUMENT) {
        return new RamlRamlDocumentImpl(node);
      }
      else if (type == RAML_DOCUMENT_END) {
        return new RamlRamlDocumentEndImpl(node);
      }
      else if (type == RAML_DOCUMENT_LIST) {
        return new RamlRamlDocumentListImpl(node);
      }
      else if (type == RAML_IRECTIVES_END) {
        return new RamlRamlDirectivesEndImpl(node);
      }
      else if (type == RAML_MEDIA_TYPE) {
        return new RamlRamlMediaTypeImpl(node);
      }
      else if (type == RAML_RESOURCE) {
        return new RamlRamlResourceImpl(node);
      }
      else if (type == RAML_RESOURCE_TYPES) {
        return new RamlRamlResourceTypesImpl(node);
      }
      else if (type == RAML_SCHEMAS) {
        return new RamlRamlSchemasImpl(node);
      }
      else if (type == RAML_SECURED_BY) {
        return new RamlRamlSecuredByImpl(node);
      }
      else if (type == RAML_SECURITY_SCHEMES) {
        return new RamlRamlSecuritySchemesImpl(node);
      }
      else if (type == RAML_STREAM) {
        return new RamlRamlStreamImpl(node);
      }
      else if (type == RAML_TAG_HANDLE) {
        return new RamlRamlTagHandleImpl(node);
      }
      else if (type == RAML_TAG_PREFIX) {
        return new RamlRamlTagPrefixImpl(node);
      }
      else if (type == RAML_TITLE) {
        return new RamlRamlTitleImpl(node);
      }
      else if (type == RAML_TRAITS) {
        return new RamlRamlTraitsImpl(node);
      }
      else if (type == RAML_VERSION) {
        return new RamlRamlVersionImpl(node);
      }
      else if (type == RESERVED) {
        return new RamlReservedImpl(node);
      }
      else if (type == SAFE) {
        return new RamlSafeImpl(node);
      }
      else if (type == SCHEME) {
        return new RamlSchemeImpl(node);
      }
      else if (type == SCHEMEPART) {
        return new RamlSchemepartImpl(node);
      }
      else if (type == SEARCH) {
        return new RamlSearchImpl(node);
      }
      else if (type == SUBTYPE) {
        return new RamlSubtypeImpl(node);
      }
      else if (type == TOKEN) {
        return new RamlTokenImpl(node);
      }
      else if (type == TOPLABEL) {
        return new RamlToplabelImpl(node);
      }
      else if (type == TSPECIALS) {
        return new RamlTspecialsImpl(node);
      }
      else if (type == TYPE) {
        return new RamlTypeImpl(node);
      }
      else if (type == UCHAR) {
        return new RamlUcharImpl(node);
      }
      else if (type == UNRESERVED) {
        return new RamlUnreservedImpl(node);
      }
      else if (type == URL) {
        return new RamlUrlImpl(node);
      }
      else if (type == URLPATH) {
        return new RamlUrlpathImpl(node);
      }
      else if (type == USER) {
        return new RamlUserImpl(node);
      }
      else if (type == VALUE) {
        return new RamlValueImpl(node);
      }
      else if (type == XCHAR) {
        return new RamlXcharImpl(node);
      }
      else if (type == X_TOKEN) {
        return new RamlXTokenImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
