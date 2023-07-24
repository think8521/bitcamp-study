package bitcamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;

public class MySQLBoardDao implements BoardDao {

  Connection con;
  int category;

  public MySQLBoardDao(Connection con, int category) {
    this.con = con;
    this.category = category;
  }

  @Override
  public void insert(Board board) {
    try (PreparedStatement stmt =
        con.prepareStatement("insert into myapp_board(title, content, writer, password, category)"
            + " values(?, ?, ?, ?, ?)")) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setString(3, board.getWriter());
      stmt.setString(4, board.getPassword());
      stmt.setInt(5, this.category);
      stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public List<Board> list() {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select board_no, title, writer, view_count, created_date from myapp_board "
                + "where category=" + this.category + " order by board_no asc")) {

      List<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_no"));
        board.setTitle(rs.getString("title"));
        board.setWriter(rs.getString("writer"));
        board.setViewCount(rs.getInt("view_count"));
        board.setCreatedDate(rs.getTimestamp("created_date"));

        list.add(board);

      }

      return list;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Board findBy(int no) {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select board_no, title, content, writer, view_count, created_date from myapp_board "
                + "where category=" + this.category + " and board_no=" + no
                + " order by board_no desc")) {

      if (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_no"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setWriter(rs.getString("writer"));
        board.setViewCount(rs.getInt("view_count"));
        board.setCreatedDate(rs.getTimestamp("created_date"));
        stmt.executeUpdate(
            "update myapp_board set" + " view_count=view_count + 1" + " where board_no=" + no);

        return board;

      }

      return null;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int update(Board board) {
    try (PreparedStatement stmt = con.prepareStatement("update myapp_board set" + " title=?,"
        + "content=?," + "writer=?" + " where password=? and category=? and board_no=?")) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setString(3, board.getWriter());
      stmt.setString(4, board.getPassword());
      stmt.setInt(5, this.category);
      stmt.setInt(6, board.getNo());

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(Board board) {
    try (PreparedStatement stmt =
        con.prepareStatement("delete from myapp_board where board_no=? and password=?")) {

      stmt.setInt(1, board.getNo());
      stmt.setString(2, board.getPassword());

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


}
