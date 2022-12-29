//package ir.lazydeveloper.dao;
//
//import ir.lazydeveloper.common.util.DBCP;
//import ir.lazydeveloper.model.Music;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class MusicDao {
//    private static final String INSERT_SQL = "INSERT INTO \"MUSIC\"(\"ID\",\"musicName\", \"artistName\", \"musicFile\",\"picFile\",\"personID\",\"updated\",\"modTime\") values (?, ?, ?,?,?,?,?,?)";
//    private static final String SEQ_MUSIC = "SELECT music_seq.nextval FROM DUAL";
//
//    public void save(Music music) throws SQLException {
//         try (Connection connection = DBCP.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
//            preparedStatement.setInt(1, getId());
//            preparedStatement.setString(2, music.getMusicName());
//            preparedStatement.setString(3, music.getArtisName());
//            preparedStatement.setBinaryStream(4, music.getMusicFile());
//            preparedStatement.setBinaryStream(5, music.getPictureFile());
//            preparedStatement.setInt(6, music.getPersonID());
//            preparedStatement.setDate(7, music.getUploaded());
//            preparedStatement.setDate(8, music.getModTime());
//            preparedStatement.executeUpdate();
//        }
//    }
//
//
//    private int getId() throws SQLException {
//        try (Connection connection = DBCP.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEQ_MUSIC)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                return resultSet.getInt(1) + 1;
//            }
//            throw new IllegalArgumentException("ID not exists");
//        }
//    }
//}
