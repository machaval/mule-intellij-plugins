# Intellij Plugin For Mule ESB
![Build status](https://travis-ci.org/machaval/mule-esb-plugin.svg?branch=master)

Join the chat at

[![Join the chat at https://gitter.im/machaval/mule-esb-plugin](https://badges.gitter.im/machaval/mule-esb-plugin.svg)](https://gitter.im/machaval/mule-esb-plugin?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

This plugin allows any Mule ESB developer to work with IntelliJ.
 
## Features

* Run Mule Configuration Integration
* Mule Debugger Integration
* Mel Script Support
    * Color Highlighting
* DataWeave Support
    * Color Highlighting
    * Code Folding
    * Outline
    * Refactoring
    * Go to declaration
* Mule Config File Support
    * Flow Subflow Outline
    * Navigate through flow-ref
    * Scripting injection inside xml.
    * Navigate from test to xml through getFlowConstruct("flowName")
    
## Status and Roadmap
    
* Support for new mule product
* Improve mel support with more features such as auto-completion and java navigation
* Graphical UI????

## Importing project into IntelliJ

To import project into IntelliJ IDEA and run plugin from within the IDE, perform the following steps:

1. Select New -> Project..., then select IntelliJ Platform Plugin project type...
2. Add the following JARs to your classpath:
    * <IntelliJ installation directory>/plugins/maven/lib/maven.jar
    * <IntelliJ installation directory>/plugins/maven/lib/maven-server-api.jar
    * <IntelliJ installation directory>/plugins/maven/lib/plexus-utils-2.0.6.jar
    * <project home>/lib/mule-plugin-debugger-3.8.0.jar
    * Add gen to the project sources, add src/main/java to the project sources and remove the src

Note, the version of gradle used to build the project is currently 2.14. If you experience build issues, check to make sure you are using this version of gradle. 

# Note
If you liked what the plugin please contribute either with code or issues.

# Disclaimer
This is not an official mulesoft product and is not a replacement for the excellent Anypoint Studio product. This means there is no support for this!
