### use-navigation-component
---

Use the navigation component by this way:

  1. check if you have `google()` in `settings.gradle (Project Settings)`
  
      also, check if you have `android.useAndroidX=true` in `gradle.properties (Project Properties)`

  2. add dependencies (choose one, to use) in `build.gradle (Module :app)`:
  
         plugins {
             ...
             id 'androidx.navigation.safeargs'
         }
         
         android {
              ...
         }
         
         dependencies {
             ...
             
             def nav_version = "2.5.3"
              
             // kotlin
             implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
             implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
         
             // java
             implementation "androidx.navigation:navigation-fragment:$nav_version"
             implementation "androidx.navigation:navigation-ui:$nav_version"
             
         }
         
  3. add below code to the `build.gradle (Project: AndroidComponents)`: 
  
      *Add to the top of `plugins` tag*
      
         buildscript {
             dependencies {
             def nav_version = "2.5.3"
             classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
             }
         }
         plugins {
            ...
         }


          
