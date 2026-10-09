# 编译与运行

本项目使用 Gradle 8.14.6、Android Gradle Plugin 8.13.2、构建 JDK 21 和 Android SDK 36。

最低支持 Android 5.1（API 22）。AppCompat 固定为 1.7.1、Material 固定为 1.13.0，ConstraintLayout 使用 2.2.2。AppCompat 1.8.0 和 Material 1.14.0 均要求最低 API 23；如果保留 API 22 支持，不要直接升级到这两个版本，否则会出现 Manifest 合并错误。这与 compile SDK 36 是不同的要求。

## Android Studio

打开项目并同步 Gradle，选择 `app` 后运行。Gradle JDK 使用 `GRADLE_LOCAL_JAVA_HOME`；它读取本机 `.gradle/config.properties` 中的 `java.home`。当前已配置为 `C:\Users\junji\.jdks\jbr-21.0.11`。

`local.properties` 中的 `sdk.dir` 指向本机 Android SDK。换电脑时需重新设置 SDK 和 JDK 路径。Android Studio 自身可以使用自带的 Java 25，但本项目的 Gradle 构建使用 Java 21。

## PowerShell

在项目根目录执行：

```powershell
$env:JAVA_HOME = 'C:\Users\junji\.jdks\jbr-21.0.11'
.\gradlew.bat :app:assembleDebug :app:assembleRelease
```

可安装的 Debug APK：`app/build/outputs/apk/debug/app-debug.apk`。

Release 输出：`app/build/outputs/apk/release/app-release-unsigned.apk`。发布前需要使用发布证书签名。

当前界面固定横屏。Manifest 已为 Android 16 平板设置横屏兼容属性，避免系统忽略方向锁定后加载缺少控件的旧默认布局。此属性适用于当前 target SDK 36；以后升级 target SDK 到 37 时，需要先完善默认布局与屏幕适配。

版本依据：[Gradle Java 兼容表](https://docs.gradle.org/8.14.6/userguide/compatibility.html)、[AGP 8.13 兼容表](https://developer.android.com/build/releases/agp-8-13-0-release-notes)。
