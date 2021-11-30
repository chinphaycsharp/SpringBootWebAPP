package com.example.demo.rest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.domain.course;
import com.example.demo.dto.courseDto;
import com.example.demo.responsitory.courseRespository;
import com.example.demo.service.courseService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


@RestController
@CrossOrigin( maxAge = 3600)
@RequestMapping("/api/course")
public class restCourseController {

	@Autowired EntityManager entity;
	
	@Autowired
	courseRespository respository;

	@Autowired
	courseService courseService;

	@GetMapping(value = "")
	public List<courseDto> getAll()
	{
		List<courseDto> l = respository.getAllCourse();
		return l;
	}

	@CrossOrigin(origins = "http://localhost:5500/")
	@GetMapping(value = "/{id}")
	public courseDto getCourse(@PathVariable String id)
	{
		courseDto dto = respository.getCourseById(new Long(id));
		return dto;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/getuserbyname")
	public List<courseDto> getCourseByName(@RequestBody courseDto courseDto)
	{
		List<courseDto> dtos = courseService.getCourseByName(courseDto.getName());
		if(dtos.size() > 0){
			return dtos;
		}
		else {
			return  null;	
		}
	}

	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping(value = "getbyuser/{id_user}")
	public List<courseDto> getCourseByIdUser(@PathVariable String id_user)
	{
		List<courseDto> dto = respository.getCourseByIdUser(new Long(id_user));
		return dto;
	}

	@CrossOrigin(origins = "http://127.0.0.1:4200")
	@PostMapping(value = "/{id}")
	public courseDto saveOrUpdate(@PathVariable String id, @RequestBody courseDto courseDto)
	{
		courseDto dto = courseService.saveOrUpdate(new Long(id), courseDto);
		return dto;
	}

	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping(value = "/{id}")
	public courseDto deleteForever(@PathVariable String id)
	{
		course c = respository.getById(new Long(id));
		courseDto dto = new courseDto(c);
		respository.delete(c);
		return dto;
	}

	@CrossOrigin(origins = "http://127.0.0.1:4200/")
	@GetMapping(value = "getcoursemanyuser")
	public List<courseDto> getcoursemanyuser()
	{
		List<courseDto> dtos = courseService.getCourseManyUser();
		return dtos;
	}

	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping(value = "exportexcel")
	public void export(WebRequest request, HttpServletResponse response)
	{
		try{
			Workbook workbook = new XSSFWorkbook();
			CreationHelper createHelper = workbook.getCreationHelper();
			Sheet sheet = workbook.createSheet("DataExport");
			Row row = sheet.createRow(0);
			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			Cell cell = row.createCell(0);
			cell.setCellValue("One");
			cell.setCellStyle(headerStyle);

			cell = row.createCell(1);
			cell.setCellValue("Two");
			cell.setCellStyle(headerStyle);

			cell = row.createCell(2);
			cell.setCellValue("Three");
			cell.setCellStyle(headerStyle);

			cell = row.createCell(3);
			cell.setCellValue("Four");
			cell.setCellStyle(headerStyle);
			List<courseDto> l = respository.getAllCourse();
			for (int i =0 ;i < l.size(); i++)
			{
				Row data = sheet.createRow(i + 1);
				data.createCell(0).setCellValue(l.get(i).getName());
				data.createCell(1).setCellValue(l.get(i).getName());
				data.createCell(2).setCellValue(l.get(i).getName());
				data.createCell(3).setCellValue(l.get(i).getName());
			}

			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);

			workbook.write(response.getOutputStream());
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=DataExport.xlsx");
			response.flushBuffer();
		}
		catch (Exception exception){
			System.out.println(exception.toString());
		}
	}
}
