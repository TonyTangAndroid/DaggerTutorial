# DaggerTutorial
A Dagger Tutorial from easiest setup example to the most advance setup examples.

[![Build status](https://build.appcenter.ms/v0.1/apps/4540c16c-9545-4eb5-8005-dca92b85a12c/branches/master/badge)](https://appcenter.ms)

The example has been broke into 9 parts with 9 branches and each part focuses on its primary purpose. And there has been 9 open pull requests which demonstrate the examples step by step. Each pull request is based on the previous commit. So if you want to learn Dagger from scratch, you could start from part_1_minu_setup which has only minimum code related to Dagger. Branch master has all the code including all parts.

(Test 123 456)

#### Part 1 : Minimum setup of Dagger.
https://github.com/TonyTangAndroid/DaggerTutorial/pull/1/files
Add a minimum setup of Dagger which injects a context in the activity to get the string.



#### Part 2 : Add SharedPreference inject example.
https://github.com/TonyTangAndroid/DaggerTutorial/pull/2/files
1, Add a shared preference module.
2, Include the shared preference module in application component.
3, Expose the shared preference interface.
4, Create a Activity component which depends on the application component.
5, Inject the activity to initial the shared preference and context in the main activity.



#### Part 3 : Add a named annotation module to demonstrate the @nAmed annotation.
https://github.com/TonyTangAndroid/DaggerTutorial/pull/4/files

1, If you only have one value for the same type of data, you could just provide it without named annotation.
In the example, we provide a boolean value from NamedAnnotationModule to inject into the MainActivity directly without any named annotation.

2, If you have more than one value for the same type data, you need to specify the named value.
In the example, we provide three different String value from NamedAnnotationModule to inject into the MainActivity.
Please pay attention that if you did not specify the annotation, the default value will be used.



#### Part 4 : Add a data, domain and presenter class.
https://github.com/TonyTangAndroid/DaggerTutorial/pull/5/files

Add a data, domain and presenter class to make things a little bit complicated and to demonstrate two potential problems here.

1, The view in the presenter has to be initialized manually as there is no way to initialize the view when the presenter is created and injected in current implementation.

2, Every time when a new value is provided, to reference it in non-module class, it has to be exposed in the Application Component. Again, this is troublesome.

In the next part, we will use the dagger android module to simplify it.



#### Part 5 : Add a data, domain and presenter class.
https://github.com/TonyTangAndroid/DaggerTutorial/pull/6/files

Add Dagger Android module to simplify the boilerplate code.

Add Dagger Android module to simplify the boilerplate code which requires to manually init the view after the presenter is created.

In this commit,

1, We remove the Activity Component that was used to be defined by ourselves.
2, We remove the exposed interface in the AppComponent.java as it is no longer necessary after we introduce the Dagger Android Module.
3, The MainView is initialized together with use case in presenter as we managed to provide the MainView in MainActivityModule before the presenter is injected.




#### Part 6 : Add a ApplicationScope
https://github.com/TonyTangAndroid/DaggerTutorial/pull/7/files

Add a ApplicationScope to create on AppComponent.java, which would make it possible that all provided dependencies will be a singleton in the application level if it has been annotated with @applicationscope.

In DataBindModule.java, we annotated PremiumRepository as ApplicationScope.
This will mean that PremiumRepository will server as a singleton.
And its construct method will be only called once. You cold verify it by the huge log printed in the console.

In DataProviderModule.java, UserRepository was not annotated as Application Scope, it is not a singleton. So it will be created as many times as it injected.



####Part 7 : Add service injector
https://github.com/TonyTangAndroid/DaggerTutorial/pull/8/files

Add service injector as an example to demonstrate that you could inject dependencies anywhere with simple configuration.

Based on this example, you could inject dependencies into Fragment, Broadcast Receiver and so on.


####Part 8 : Add service injector
https://github.com/TonyTangAndroid/DaggerTutorial/pull/9/files

Add a tile service which only exists in Android 24 or later to demonstrate a potential problem in Dagger, which will crash the app on start if it runs devices with Android API below 24. For details, please refer to this issue in Dagger google/dagger#1064



####Part 9 : Fix the crash at app start on device with Android Api below 24.
https://github.com/TonyTangAndroid/DaggerTutorial/pull/10/files

Fix the crash at app start on device with Android Api below 24 due to the TileService error. This could serve as an example to delay the preparation of initialization until the injected class is being called.

####Part 10 : Optimize the service injector

https://github.com/TonyTangAndroid/DaggerTutorial/pull/11/files
Optimize the service injector 
