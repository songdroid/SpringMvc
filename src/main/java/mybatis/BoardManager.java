package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.netsong7.board.repository.BoardDto;

public class BoardManager {
	private static SqlSessionFactory sqlFactory;
	static{
		try{
			Reader reader = 
				Resources.getResourceAsReader("mybatis/sqlmapConfig.xml");
			sqlFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		catch(IOException err){
			throw new RuntimeException("SqlSessionFactory 인스턴스 생성 실패 : " + err);
		}
	}
	
	public static List getList(){
		List list = null;
		SqlSession session = sqlFactory.openSession();
		list = session.selectList("getList");
		return list;
	}
	
	public static void write(BoardDto dto){
		SqlSession session = sqlFactory.openSession();
		session.insert("write", dto);
		session.commit();
	}
	
	public static BoardDto findBySeq(int seq){
		SqlSession session = sqlFactory.openSession();
		BoardDto dto = session.selectOne("findBySeq", seq);
		return dto;
	}
	
	public static void update(BoardDto dto){
		
	}
	
	public static void delete(int seq){
		
	}
}
