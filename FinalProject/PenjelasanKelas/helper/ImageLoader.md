# ☕️ ImageLoader Class

****
### 💡Penjelasan:
Kelas ini berfungsi untuk memuat foto pada folder res.

### 💡Atribut dan Fungsi:
Ada 2 jenis fungsi:
- loadImage: fungsi yang dimaksudkan untuk memudahkan read image.
- toBufferedImage: untuk mengubah file bertipe Image menjadi BufferedImage.

****
```java
package id.ac.its.trexucul.utils.helper;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadImage(String path){
		try {
			return ImageIO.read(new File(path));
//			return ImageIO.read(ImageLoader.class.getClassLoader().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
	
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }else if(img==null) {
	    	return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
}
```
