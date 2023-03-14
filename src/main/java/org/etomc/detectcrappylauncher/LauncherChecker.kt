package org.etomc.detectcrappylauncher

import java.io.File

/**
 * A library checks Minecraft Launcher
 * @author ETO-MC
 */
object LauncherChecker {
    /**
     * run full Launcher check
     * @param mcDir minecraft folder path
     * @param deleteFolder delete Launcher data folder for next Launcher deleted check
     * @return check result
     */
    @JvmOverloads
    fun fullCheck(mcDir: File, launcherWindowName: String, deleteFolder: Boolean = true): Boolean {
        // check if there is a window named Launcher
        if (titleCheck(launcherWindowName))
            return true

        // maybe the window not exists like close the window after launched , so we need to check the Launcher data folder
        if (folderCheck(mcDir, deleteFolder))
            return true

        // Launcher is not exists in the PC
        return false
    }

    /**
     * run Launcher title check
     * check if there exists a title name contained Launcher
     * @return check result
     */
    fun titleCheck(launcherWindowName: String): Boolean {
        return if (!WindowCheckUtils.isWindows()) {
            false // PCL and the native file only support windows
        } else {
            val targetStr=launcherWindowName
            WindowCheckUtils.getWindowNames().find { it.length < targetStr.length*2 && it.contains(targetStr) } != null
        }
    }

    /**
     * run Launcher data folder check
     * @param mcDir minecraft folder path
     * @param deleteFolder delete Launcher data folder for next PCL deleted check
     * @return check result
     */
    fun folderCheck(mcDir: File, deleteFolder: Boolean): Boolean {
        require(mcDir.exists()) { "Argument \"mcDir\" is not exists" }
        require(mcDir.isDirectory) { "Argument \"mcDir\" should be a folder" }

        var exists = false
        val pclDataDir = File(mcDir, "PCL")
        if (pclDataDir.exists()) {
            if (deleteFolder)
                pclDataDir.deleteRecursively()
            exists=true
        } // me need to delete all folders

        val mcVersionDir = File(mcDir, "versions")
        if (mcVersionDir.exists()) { // I think this should be existed but ...
            mcVersionDir.listFiles().forEach {
                val pclVersionDataDir = File(it, "PCL")
                if (pclVersionDataDir.exists()) {
                    if (deleteFolder)
                        pclVersionDataDir.deleteRecursively()
                    exists = true
                }
            }
        }

        return exists
    }
}