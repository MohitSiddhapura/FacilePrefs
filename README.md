# Facile Prefs 

- Simplest version of Sharedpreferences with kotlin delegation.
- Remove some boiler point code for get and set Sharedpreferences data. like prefs.getString() or prefs.putString() etc.


## How to integrate into your app

Integrating the library into you app is extremely easy. A few changes in the build gradle and your all ready to use FacilePrefs. Make the following changes.

> Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```

> Step 2. Add the dependency into build.gradle flie(Module level).

```gradle
dependencies {
        implementation 'com.github.MohitSiddhapura:FacilePrefs:1.0.1'
}
```
## Configure

> step 1. Configure FacilePrefs Instance in application class.
``` kotlin
class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        FacilePrefs.context = this
    }
}
```

> Step 2. Create an Object class in project and define prefs varible in it.
``` kotlin
object Prefs {

    var NAME by FacilePrefs(String::class.java)
    
}
```
## How to use the library

Okay seems like you integrated the library in your project but **how do you use it?** Well its really easy just follow the steps below.

**Set Value**

``` kotlin
    Prefs.NAME = "Mohit Siddhapura"
```

**Get Value**

``` kotlin
    txtName.text = Prefs.NAME.toString()
```

**Remove Value**

``` kotlin
    FacilePrefs.remove(Prefs.NAME.toString())
```

**Get All Keys & Value**

``` kotlin
    FacilePrefs.getAll()
```

**Clear All**

``` kotlin
    FacilePrefs.clear()
```

That's pretty much it. Looks like your all done here.
## Author

Mainteined by [Mohit Siddhapura](https://github.com/MohitSiddhapura)
