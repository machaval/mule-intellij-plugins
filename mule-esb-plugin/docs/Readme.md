# Mule Runtime plugin for IntelliJ IDEA
**version 0.10**

[Features](#Features)

[Pre-requisites](Pre-requisites)

[Installation](Installation)

[Live templates](#Livetemplates)



## Features
- supports Mule Runtime versions 3.7 to 3.8.x
- supports Mule Domain projects
- multiple applications can be launched in a single Run Configuration
- properties encryption and decryption
- Mule configuration XML files debugger
- APIKit and APIKit SOAP scaffolding
- Pre-defined live templates for common Mule elements and expressions

## Pre-requisites
- IntelliJ IDEA Community Edition version 2016 or later
- Oracle JDK (not JRE!) version 1.8 or later
- Apache Maven 3.3+

## Installation
To download and install Mule Runtime plugin:
1. Open the IntelliJ **Settings** dialog
2. In the left-hand pane, select **Plugins**
3. Click the **Browse Repositories...** button
4. Search for **Mule ESB plugin** and click the **Install** button

This will also install two other plugins from the suite, the **DataWeave plugin** and the **RAML plugin**.

## Creating Mule applications
1. If no project is currently open in IntelliJ IDEA, click **Create New Project** on the Welcome screen. Otherwise, select **File | New | Project**.
As a result, the New Project wizard opens.
2. Select the **Mule Application** project category in the left pane of the New Project window.
3. Select the Mule Runtime version from the drop-down menu. If there are no versions available, click the **New...* button and the **Mule SDK** dialog appears.
   1. If there is an existing Mule Runtime installation, click the **+** button and navigate to the directory where Mule is installed (i.e. the *MULE_HOME*)
   2. If there are no Mule Runtimes installed, click the **Download a version** button and select Mule Runtime version to download and the installation directory.
4. Follow the prompts on the next wizard screens to set the artifact ID, group ID, version and project location.

## Run configurations

## Properties encryption and decryption

## APIKit scaffolding

## Live templates

Test only

