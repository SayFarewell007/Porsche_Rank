package leon.sms.mapper;

import java.util.List;
import leon.sms.pojo.Project;

/** 
* @author Leon
* @date ����ʱ�䣺2018��4��7�� ����2:06:10
* @version 1.0
* ��˵�� :
* 
*/
public interface ProjectMapper
{
	public void add(Project project);

	public void delete(int id);

	public Project get(int id);

	public void update(Project project);

	public List<Project> list();

	public int count();

	public List<Project> findProjects(String clientName);
}
