package poly.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;

import poly.model.Video;

public class UploadUtils {

	public static String processUploadFile(String fileName, HttpServletRequest request, String storedFolder,
			String storedFilename) throws IOException, ServletException {
		Part filePart = request.getPart(fileName);

		if (filePart == null || filePart.getSize() == 0) {
			return "";
		}
		
		if (storedFolder == null) {
			storedFolder = "/uploads";
		}

		if (storedFilename == null) {
			storedFilename = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
		} else {
			storedFilename += "." + FilenameUtils.getExtension(Path.of(filePart.getSubmittedFileName()).toString());
		}

		String uploadFolder = request.getServletContext().getRealPath(storedFolder);

		Path uploadPath = Paths.get(uploadFolder);

		if (!Files.exists(uploadPath)) {
			Files.createDirectory(uploadPath);
		}

		filePart.write(Paths.get(uploadPath.toString(), storedFilename).toString());

		return storedFilename;
	}

	public static String processUploadFileUser(String fileName, HttpServletRequest request, String storedFolder,
			String storedFilename) throws IOException, ServletException {
		Part filePart = request.getPart(fileName);

		if (filePart == null || filePart.getSize() == 0) {
			return "";
		}
		
		if (storedFolder == null) {
			storedFolder = "/uploadUser";
		}

		if (storedFilename == null) {
			storedFilename = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
		} else {
			storedFilename += "." + FilenameUtils.getExtension(Path.of(filePart.getSubmittedFileName()).toString());
		}

		String uploadFolder = request.getServletContext().getRealPath(storedFolder);

		Path uploadPath = Paths.get(uploadFolder);

		if (!Files.exists(uploadPath)) {
			Files.createDirectory(uploadPath);
		}

		filePart.write(Paths.get(uploadPath.toString(), storedFilename).toString());

		return storedFilename;
	}

	
	public static byte[] setImage(String fileName, HttpServletRequest request) throws IOException, ServletException {

		File dir = new File(request.getServletContext().getRealPath("/files"));
		if (!dir.exists()) { // tạo nếu chưa tồn tại
			dir.mkdirs();
		}
		Part photo = request.getPart(fileName); // file hình
		File photoFile = new File(photo.getSubmittedFileName());
		photo.write(photoFile.getAbsolutePath());
		byte[] bFile = new byte[(int) photoFile.length()];
		try {
			FileInputStream fileInputStream = new FileInputStream(photoFile);
			// convert file into array of bytes
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFile;
	}

	public static Object getImage(byte[] bytes) {
		try {
			InputStream is = new ByteArrayInputStream(bytes);
			BufferedImage bi = ImageIO.read(is);
			return bi;
		} catch (IOException ex) {

		}
		return null;
	}
}
