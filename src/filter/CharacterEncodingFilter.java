package filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class CharacterEncodingFilter implements Filter {
	private String characterEncoding;//编码方式在配置文件“web.xml”中
	private boolean enabled;//是否启动filter，该项的初始值也在“web.xml”中配置
	public void init(FilterConfig config) throws ServletException {//初始化时加载参数
		characterEncoding = config.getInitParameter("characterEncoding");//从配置文件中取出设置的编码方式
		enabled = "true".equalsIgnoreCase(characterEncoding.trim())
				|| "1".equalsIgnoreCase(characterEncoding.trim());//启动该过滤器完成编码方式的修改
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (enabled || characterEncoding != null) {
			request.setCharacterEncoding(characterEncoding);//设置request的编码
			response.setCharacterEncoding(characterEncoding);//设置response的编码
		}
		chain.doFilter(request, response);//doFilter将修改好的request和response参数向下传递
	}
	public void destroy() {
		characterEncoding = null;//销毁时清空资源
	}
}
