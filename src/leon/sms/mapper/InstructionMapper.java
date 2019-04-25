package leon.sms.mapper;

import java.util.List;
import leon.sms.pojo.Instruction;

/** 
* @author Leon
* @date ����ʱ�䣺2018��4��7�� ����2:05:50
* @version 1.0
* ��˵�� :
* 
*/
public interface InstructionMapper
{
	public void add(Instruction instruction);

	public void delete(int id);

	public Instruction get(int id);

	public void update(int id);

	public List<Instruction> list(String staffName);

	public int count();
}
