import filemodifier.FileAccesser;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileAccesser fileAccesser = new FileAccesser();
        fileAccesser.deleteTextureFolders();
        fileAccesser.forceNoTextures();
    }
}
