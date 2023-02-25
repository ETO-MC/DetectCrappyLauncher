# DetectCrappyLauncher

一个检测蹩脚的启动器（Plain Craft Launcher）的库，从[UnlegitMinecraft/FuckPCL](https://github.com/UnlegitMinecraft/FuckPCL)修改而来。

# 使用
如果你的项目使用 Kotlin：
~~~kotlin
import org.etomc.dclauncher.LauncherChecker
LauncherChecker.fullCheck(Minecraft.getMinecraft().mcDataDir/*, true*/) // boolean
~~~
如果你的项目使用 Java：
~~~java
import org.etomc.dclauncher.LauncherChecker;
LauncherChecker.INSTANCE.fullCheck(Minecraft.getMinecraft().mcDataDir/*, true*/);
~~~