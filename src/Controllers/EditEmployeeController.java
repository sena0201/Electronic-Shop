package Controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Model_BO.EmployeeBO;

/**
 * Servlet implementation class EditEmployeeController
 */
@WebServlet("/EditEmployeeController")
public class EditEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 String folder = "employee-img";
		 String nameImg = "";
		 
		try {
			List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
				String employeeID = null;
				String employeeName = null;
				String password = null;
				//duyệt qua các đối tượng gửi lên từ client gồm file và các control
				for (FileItem fileItem : fileItems) {
					if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
						// xử lý file
						nameImg = fileItem.getName();

						if (!nameImg.equals("")) {
							//Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String dirUrl = getServletContext().getRealPath("")  +  File.separator + folder;
							File dir = new File(dirUrl);
							if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
								dir.mkdir();
							}
							String fileImg = dirUrl + File.separator + nameImg;
							File file = new File(fileImg);//tạo file
							try {
								fileItem.write(file);//lưu file
								System.out.println("UPLOAD THÀNH CÔNG...!");
								System.out.println("Đường dẫn lưu file là: "+dirUrl);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
					else//Neu la control
					{
						String tentk=fileItem.getFieldName();
						if(tentk.equals("employeeID"))
							employeeID = fileItem.getString("utf-8");
						if(tentk.equals("employeeName"))
							employeeName = fileItem.getString("utf-8");
						if(tentk.equals("password"))
							password = fileItem.getString("utf-8");
					}
				}
				String photo = "";
				if(nameImg.length() > 1) {
					photo = "./" + folder + "/" + nameImg;
				}
				try {
					if(employeeID == "" || employeeName == "" || password == "") {
						request.setAttribute("warning", "Failed");
						request.getRequestDispatcher("AdEditEmployeeController").forward(request, response);
					}else
					if(employeeID != null && employeeName != null && password != null && employeeID != "" && employeeName != ""  && password != "") {
						EmployeeBO employeeBO = new EmployeeBO();
						int check = employeeBO.Edit(Long.parseLong(employeeID), employeeName, photo, password);
						if(check > 0) {
							request.setAttribute("warning", "Success!");
							request.getRequestDispatcher("AdEmployeeController").forward(request, response);
						}
						else {
							request.setAttribute("warning", "Failed");
							request.getRequestDispatcher("AdEmployeeController").forward(request, response);
						}
					}else {
						request.setAttribute("warning", "Failed");
						request.getRequestDispatcher("AdEmployeeController").forward(request, response);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
