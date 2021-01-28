# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


# Proguard will obfuscate your code, so it will be renaming your classes and you will run into some build/runtime
# errors saying that your library classes are not found.
# To solve this you will always need to keep your library’s public APIs away from obfuscation.
# This is easily done by adding these classes to proguard-rules.pro file.


-keepclassmembers class nz.co.applog.library_about.R {*;}