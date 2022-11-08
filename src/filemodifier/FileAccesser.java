package filemodifier;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileAccesser {
    private final List<String> textureFoldersList = new ArrayList<>(Arrays.asList("brick", "cobblestone", "concrete", "corrodedmetal", "diamondplate", "fabric", "foil", "granite", "grass", "ice", "marble", "metal", "pebble", "plastic", "sand", "slate", "wood", "woodplanks"));

    private final File robloxDirectory = new File("C:\\Users\\jaron\\AppData\\Local\\Roblox\\Versions\\" + getFolder(new File("C:\\Users\\jaron\\AppData\\Local\\Roblox\\Versions"))[1]);
    private final File texturesDirectory = new File(robloxDirectory + "\\PlatformContent\\pc\\textures\\");
    private final String texturesDirectoryStr = new String("C:\\Users\\jaron\\AppData\\Local\\Roblox\\Versions\\" + getFolder(new File("C:\\Users\\jaron\\AppData\\Local\\Roblox\\Versions"))[1] + "\\PlatformContent\\pc\\textures\\");

    public FileAccesser() {}

     public void deleteTextureFolders() {
        String[] textureFolders = getFolder(texturesDirectory);
        for (String textureFolder : textureFolders) {
            if (textureFoldersList.contains(textureFolder)) {
                deleteDirectory(new File(texturesDirectoryStr + textureFolder));
            }
        }
    }

     public void forceNoTextures() throws IOException {
        File clientSettingsDirectory = new File(robloxDirectory + "\\ClientSettings");
        if (!clientSettingsDirectory.exists()) {
            clientSettingsDirectory.mkdirs();
        }
        File clientSettingsFile = new File(clientSettingsDirectory + "\\ClientAppSettings.json");
        FileWriter fileWriter = new FileWriter(clientSettingsFile);
        fileWriter.write("{\"FFlagDebugDisableOTAMaterialTexture\":\"true\"}");
        fileWriter.close();
    }

     private void deleteDirectory(File file) {
        for (File subfile : file.listFiles()) {
            if (subfile.isDirectory()) {
                deleteDirectory(subfile);
            }
            subfile.delete();
        }
    }

     private String[] getFolder(File dir) {
        File directory = dir;
        String[] folder = directory.list();
        return folder;
    }
}
