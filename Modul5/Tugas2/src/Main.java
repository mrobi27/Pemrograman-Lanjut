import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) {
        try {
            String folder = "gambar/";
            File originalFile = new File(folder + "image.jpg");

            BufferedImage originalImage = ImageIO.read(originalFile);

            int width = 200;
            int height = 200;
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(originalImage, 0, 0, width, height, null);
            g2d.dispose();

            File resizedFile = new File(folder + "resized_image.jpg");
            ImageIO.write(resizedImage, "jpg", resizedFile);
            System.out.println("Gambar berhasil disimpan sebagai resized_image.jpg");

            File copiedFile = new File(folder + "copied_image.jpg");
            Files.copy(resizedFile.toPath(), copiedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Salinan gambar berhasil dibuat dengan nama copied_image.jpg");

            File newFolder = new File("gambar/hasil/");
            if (!newFolder.exists()) newFolder.mkdir();

            Files.move(copiedFile.toPath(),
                    new File("gambar/hasil/copied_image.jpg").toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Salinan gambar berhasil dipindahkan ke folder 'hasil'");

            File pngFile = new File(folder + "image_converted.png");
            ImageIO.write(resizedImage, "png", pngFile);
            System.out.println("Format gambar berhasil diubah menjadi PNG dan disimpan dengan nama image_converted.png");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
