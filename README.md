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

---

For more information click [here](https://developer.android.com/guide/navigation/navigation-getting-started) 
and [here](https://developer.android.com/topic/libraries/architecture/adding-components#navigation)

---

## Usage
 ****Send data by [Safeargs](https://developer.android.com/guide/navigation/navigation-pass-data)****
 
 ****to see a sample you can check `master` branch.****
 
 ### ---
 
  Actually I beleive one of the bes learn-way is to learn with example. So, Let's say we want to send data(name, age, email 
  & password) from `MainFragment` to `ResultFragment` by navcontroller and show. How can we do this?
  
  Let me tell you:
  
  *(in `nav_graph` file):*
  1. *You create an action (from `MainFragment(which has a home icon at the top)` to the `ResultFragment(that hasn't; 'you want show data there')`)*
  2. *Add an **argument** to the `ResultFragment` (You can also, do it by click on `Design` >`Attributes` >`Arguments` > `+`)*
  3. *It's better to `build` your project after add-argument(s). Will add some classes.*
  
  *[(in MainFragment)](https://github.com/fekri86114/use-navigation-component/blob/master/app/src/main/java/info/fekri/androidcomponents/MainFragment.kt#:~:text=class%20MainFragment%20%3A%20Fragment()%20%7B):*
  
  1. *Get data and do the relevant works(check null, ...)*
  2. *To send data by safeargs, use `findNavController().navigate()`:*
  
         findNavController()
             .navigate(
                 MainFragmentDirections // The Sender-Data-Activity has this
                     .actionMainFragmentToResultFragment()
                     .setMyName(name) // it comes from the arguments that you've defined. give that you received from the user.
                     .setMyAge(age) // ...
                     .setMyEmail(email) // ...
                     .setMyPassword(password) // ...
             )
      
  *(in ResultFragment):*
  *In fact, we want to get and set -->*
  
      val name: String = ResultFragmentArgs.fromBundle(requireArguments()).myName
      val age: Int = ResultFragmentArgs.fromBundle(requireArguments()).myAge
      val email: String = ResultFragmentArgs.fromBundle(requireArguments()).myEmail
      val password: String = ResultFragmentArgs.fromBundle(requireArguments()).myPassword
      
  *To set data:*
      
      binding.txtShowName.text     = name
      binding.txtShowAge.text      = age.toString()
      binding.txtShowEmail.text    = email
      binding.txtShowPassword.text = password
      
---

And finally, happy codding😍😝✌


