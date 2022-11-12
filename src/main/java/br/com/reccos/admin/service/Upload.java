package br.com.reccos.admin.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Upload {

	public String uploadFile(MultipartFile arquivo) {
		try {
			System.out.println("DEBUG - "+arquivo.getOriginalFilename());
			String caminho = "D:\\TCC\\front_end\\imagens\\";
//			String caminho = "/var/www/leetir.com.br/assets/images/";
			Path path = Paths.get(caminho + File.separator + arquivo.getOriginalFilename());
			Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("DEBUG - Arquivo copiado...");
			return arquivo.getOriginalFilename();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
