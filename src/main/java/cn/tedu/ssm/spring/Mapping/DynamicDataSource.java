package cn.tedu.ssm.spring.Mapping;
/**
 * 重写上面的determineCurrentLookupKey方法，我们新建一个创建一个DynamicDataSource的类，用来获取自定义获取数据源的标识
 */
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

public class DynamicDataSource  extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return DynamicDataSourceHolder.getDataSource();
	}
	
}
