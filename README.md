# DetectCrappyLauncher

A library to detect crappy launcher(Plain Craft Launcher), modified from [UnlegitMinecraft/FuckPCL](https://github.com/UnlegitMinecraft/FuckPCL).

# Use
If your project are on kotlin
~~~kotlin
import org.etomc.detectcrappylauncher.LauncherChecker

LauncherChecker.fullCheck(Minecraft.getMinecraft().mcDataDir/*, true*/) // boolean
~~~
If your project are on java
~~~java
import org.etomc.detectcrappylauncher.LauncherChecker;

LauncherChecker.INSTANCE.fullCheck(Minecraft.getMinecraft().mcDataDir/*, true*/);
~~~