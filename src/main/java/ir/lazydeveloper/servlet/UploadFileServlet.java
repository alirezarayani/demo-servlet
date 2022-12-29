//package ir.lazydeveloper.servlet;
//
//import ir.lazydeveloper.common.util.ToolsDate;
//import ir.lazydeveloper.dao.MusicDao;
//import ir.lazydeveloper.model.Accessor;
//import ir.lazydeveloper.model.Music;
//import lombok.SneakyThrows;
//import org.apache.commons.fileupload.FileItemIterator;
//import org.apache.commons.fileupload.FileItemStream;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//import java.io.IOException;
//import java.sql.SQLException;
//
//@WebServlet(name = "Upload File", urlPatterns = "/upload")
//@MultipartConfig(maxFileSize = 16177215)
//public class UploadFileServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        boolean isMultiPart = ServletFileUpload.isMultipartContent(req);
//        HttpSession session = req.getSession();
//        Accessor accessor = (Accessor) session.getAttribute("Accessor");
//        Music music = new Music();
//        if (accessor != null && isMultiPart) {
//            try {
//                ServletFileUpload servletFileUpload = new ServletFileUpload();
//                FileItemIterator itemIterator = servletFileUpload.getItemIterator(req);
//                while (itemIterator.hasNext()) {
//                    FileItemStream fileItemStream = itemIterator.next();
//                    if (fileItemStream.getFieldName().equalsIgnoreCase("picture")) {
//                        setMusicPicture(fileItemStream, music);
//                    } else if (fileItemStream.getFieldName().equalsIgnoreCase("Music")) {
//                        setMusicFile(fileItemStream, music);
//                    } else if (fileItemStream.getFieldName().equalsIgnoreCase("MusicName")) {
//                        music.setMusicName(fileItemStream.getName());
//                    } else if (fileItemStream.getFieldName().equalsIgnoreCase("ArtistName")) {
//                        music.setArtisName(fileItemStream.getName());
//                    }
//                }
//                music.setUploaded(ToolsDate.getNow());
//                music.setModTime(ToolsDate.getNow());
//                music.setPersonID(accessor.getPersonID());
//                MusicDao musicDao = new MusicDao();
//                musicDao.save(music);
//            } catch (FileUploadException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
////        HttpSession session = req.getSession();
////        Accessor accessor = (Accessor) session.getAttribute("Accessor");
////        String musicName = req.getParameter("MusicName");
////        String artistName = req.getParameter("ArtistName");
////        if (!musicName.isEmpty() && !artistName.isEmpty()) {
////            music.setMusicName(musicName);
////            music.setArtisName(artistName);
//////            setMusicPicture(req, music);
//////            setMusicFile(req, music);
//
////        }
////        MusicDao musicDao = new MusicDao();
////        try {
////            musicDao.save(music);
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
//
//    }
//
//    private void setMusicPicture(FileItemStream fileItemStream, Music music) throws IOException {
//        music.setPictureFile(fileItemStream.openStream());
//    }
//
//    private void setMusicFile(FileItemStream fileItemStream, Music music) throws IOException {
//        music.setMusicFile(fileItemStream.openStream());
//    }
//}
