# thorntail-azure

Run Thorntail ueber-jar as Azure App Service.

## Prerequisites

Build a simple Thorntail app. Beware that the static page must not be in the scope of  the Jax-Rs application.

    mvn clean package

Local test: Run the bat-file.

Caution: The Azure maven plugin will do a check on the manifest via JarInputStream#getManifest. This needs the manifesst at the first entry in the jar. This is *not* supported by Thorntail at the moment. You can reorder the entries via Windows built in Zip but not with 7Zip (it will reorder all the time) se

See https://bugs.openjdk.java.net/browse/JDK-8031748

Optional: Download and install Azure CLI.

## Azure

Portal: https://portal.azure.com/#home

There is a maven plugin that can be used to upload the app to Azure.
Unfortunately the default authType (MAVEN_PLUGIN) seems not to work, because no subscription was found. 

See also here: https://github.com/MicrosoftDocs/azure-dev-docs/issues/127

Alternatively using authType AZURE_CLI is working. Therefore first you have to login via Azure cli:

    az login

This returns the current account as Json.

Then you can deploy via the plugin:

  
    mvn azure-webapp:deploy

The deployed app can be found here: https://[app-name].azurewebsites.net/
