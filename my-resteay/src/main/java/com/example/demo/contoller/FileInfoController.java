/**
 * FileName: FileInfoContoller
 * Author:   13235
 * Date:     2019/1/13 18:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.contoller;

import com.example.demo.domain.FileInfo;
import com.example.demo.exception.CommonResult;
import com.example.demo.service.FileInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/13
 * @since 1.0.0
 */
@Controller
@Path("/fileInfo")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Component
@Api("文件信息类")
@Slf4j
public class FileInfoController {


    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private RestTemplate restTemplate;

    @GET
    @Path("/all")
    @ApiOperation(value = "获取所有文件信息", response = CommonResult.class)
    @ApiResponse(code = 200, message = "成功！", response = CommonResult.class)
    public CommonResult findAll() {
        List<FileInfo> all = fileInfoService.getAll();
        return CommonResult.create(all);
    }

    @GET
    @Path("/download")
    @ApiOperation(value = "下载文件", response = CommonResult.class)
    @ApiResponse(code = 200, message = "成功！", response = CommonResult.class)
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@QueryParam("path") String path) {
        Response result = null;
        try {
            byte[] bytes = FileUtils.readFileToByteArray(new File("d:" + File.separator + path + ".txt"));
            return Response.ok(bytes).header("Content-Disposition", "attachment;filename=" + URLEncoder.encode("gg", "utf-8") + ".txt").build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @POST
    @Path("/save")
    @ApiOperation(value = "保存文件信息", response = CommonResult.class)
    @ApiResponse(code = 200, message = "成功！", response = CommonResult.class)
    public CommonResult save(FileInfo fileInfo) {
        fileInfoService.editFileInfo(fileInfo);
        return CommonResult.create(fileInfo);
    }

    @Path("/delete/{id}")
    @GET
    @ApiOperation(value = "删除文件信息", response = CommonResult.class)
    @ApiResponse(code = 200, message = "成功！", response = CommonResult.class)
    public CommonResult delete(@ApiParam("文件id") @PathParam("id") Integer id) {
        fileInfoService.deleFileInfo(id);
        return CommonResult.create(id);
    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "上传文件", response = CommonResult.class)
    @ApiResponse(code = 200, message = "成功！", response = CommonResult.class)
    public CommonResult upload(@Context HttpServletRequest request, MultipartFormDataInput file) {

        System.out.println("地址是：" + request.getContextPath());
        Map<String, List<InputPart>> formDataMap = file.getFormDataMap();
        List<InputPart> file1 = formDataMap.get("file");
        String fileName = "";
        for (InputPart inputPart : file1) {
            try {
                InputStream body = inputPart.getBody(InputStream.class, null);
                MultivaluedMap<String, String> headers = inputPart.getHeaders();
                fileName = findFileName(headers);
                byte[] bytes = IOUtils.toByteArray(body);
                String path = "D:" + File.separator + fileName;
                writeFile(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return CommonResult.create(200, "上传成功！", fileName);
    }

    private void writeFile(String path, byte[] bytes) throws IOException {
        File file = new File(path);
        FileUtils.writeByteArrayToFile(file, bytes);
    }

    /**
     * 获取文件名称
     *
     * @param headers
     * @return
     */
    private String findFileName(MultivaluedMap<String, String> headers) {
        String[] contentDisposition = headers.getFirst("Content-Disposition").split(";");
        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {
                String[] name = filename.split("=");
                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }

    @POST
    @Path("/uploadRemote")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "上传文件调用第三方服务", response = CommonResult.class)
    @ApiResponse(code = 200, message = "成功！", response = CommonResult.class)
    public CommonResult uploadRemote(MultipartFormDataInput file) {
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.MULTIPART_FORM_DATA);
        Map<String, List<InputPart>> formDataMap = file.getFormDataMap();
        List<InputPart> file1 = formDataMap.get("file");
        InputPart inputPart = file1.get(0);
        try {
            InputStream body = inputPart.getBody(InputStream.class, null);
            MultivaluedMap<String, String> requestHeaders = inputPart.getHeaders();
            String fileName = findFileName(requestHeaders);
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
            ByteArrayResource arrayResource = new ByteArrayResource(IOUtils.toByteArray(body)) {
                @Override
                public String getFilename() {
                    return fileName;
                }
            };
            map.add("file", arrayResource);
            HttpEntity<MultiValueMap<String, Object>> httpRequest = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
            return restTemplate.postForObject("http://localhost:9091/xkf/api/fileInfo/upload", httpRequest, CommonResult.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new CommonResult();
    }


}
