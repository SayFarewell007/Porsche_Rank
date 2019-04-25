package leon.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leon.sms.mapper.ProjectMapper;
import leon.sms.pojo.Project;

/** 
* @author Leon
* @date ����ʱ�䣺2018��5��2�� ����4:17:08
* @version 1.0
* ��˵�� :
* 
*/
@Service
public class ProjectService
{
	@Autowired
	ProjectMapper projectMapper;
	
	public List<Project> searchByName(String name)
	{
		List<Project> list = projectMapper.list();
		List<Project> result = new ArrayList<Project>();
		for(int i = 0;i<list.size();i++)
		{
			if(name.equals(list.get(i).getStaffName()))
			{
				result.add(list.get(i));
			}
		}
		return result;
	}
	public List<Project> getAll()
	{
		List<Project> list = projectMapper.list();
		return list;
	}
}
