<H1>Koin dependency injection set up guide </h1>
Guide for setting up Koin dependency injection on Android and iOS apps.

<h3>Step 1: Add dependencies to gradle for koin</h3>
Add the versions to libs.versions.toml
Add the dependencies to the gradle file
(see both files for examples)

<h3>Step 2: Create your dependency</h3>
In this case we create composeApp/commonmain/dependencies directory

DbClient is an example using expect keyword. This creates a platform specific implementation that can be automatically generated.

MyRepository is an example of repo that uses DbClient which is injected through iOS and 
Android implementations

<h3> Step 3: create your shared and platform modules in di/Modules</h3>
In Shared module we can call bind to our repository to the implementation of the repo.

We use expect for platformModule which will generate a platform module for platform.

In androidMain/dependencies/DbClient.android we have the actual which takes the android  specific
context in the constructor.

In nativeMain/dependencies/DbClient.native we just have an instance of the class but can inject iOS 
dependencies it may need.

<h3> Step 4: Create initKoin function in commonMain/kotlin/di/InitKoin </h3>
This function takes the modules and should be called in the entry points for each platform

<h3> Step 5: Call init Koin at the entry points for each platform </h3>
For Android this is androidmain/kotlin/com.danfoleyapps.diwithkoin and create MyApplication.

- Here call initKoin function and pass the context that it needs for DbClient. Wherever that dependency is injected (In the VM for example) Koin knows to check the platform specific module. These modules expect that the platform dependencies they need are passed at the entry points

- Don't forget to a add MyApplication to the Android manifest

For iOS, go to MainViewController and call initKoin() (passing dependencies needed for iOS) in the configuration parameter of ComposeUIViewController()

<h3> Set KoinContext composable in the app() function </h3>
All di must occur with this KoinContext Composable

<h3> Step 6:Call dependencies </h3>
Can get instances directly from Koin but this is not recommend to do in the UI(see App for example).

To get the viewmodel in the navHost, call it using koinViewModel and pass it to the screen 
composable.

<h3>How it works? </h3>
<ul>
  <li>Koin gets dependencies at run time unlike Dagger Hilt.</li>
  <li>RepositoryImpl are bound to the repository in the Modules file.</li>
  <li>SingleOf(::ClassName) is used to create a singleton</li>
  <li>viewModelOf(::ViewModelName) is used to create vm's</li>
  <li>Platform specific dependencies are created which are then referenced when injected</li>
  <li>hese Platform dependencies need to added at the platform entry point</li>


Daniel Foley
