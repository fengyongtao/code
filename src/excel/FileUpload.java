package excel;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 将客户端传来的文件写入到服务器中,返回是否执行成功
 * @author FengYongTao
 *
 */
public class FileUpload {

	public static boolean doUpload(String fileName, MultipartFile multipartFile) {
		boolean flag = true;
		try {
	        // 把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
	        CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
	        
	        // 获取本地存储路径
	        File dir = new File("/usr/local/tomcat/fileUpload");
	        // 判断文件夹是否存在，如果不存在需创建
	        if (!dir.exists()) {
	        	dir.mkdirs();
	        }
	        // 判断文件是否存在，如果存在同名文件需删除掉
	        File file = new File("/usr/local/tomcat/fileUpload/" + fileName);
	        if (file.exists()) {
	            file.delete();
	        }
	        // 将上传的文件写入到指定的文件中
            cf.getFileItem().write(file);
        } catch (Exception e) {
        	flag = false;
            e.printStackTrace();
        }
		return flag;
	}
	
}
