package filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class CharacterEncodingFilter implements Filter {
	private String characterEncoding;//���뷽ʽ�������ļ���web.xml����
	private boolean enabled;//�Ƿ�����filter������ĳ�ʼֵҲ�ڡ�web.xml��������
	public void init(FilterConfig config) throws ServletException {//��ʼ��ʱ���ز���
		characterEncoding = config.getInitParameter("characterEncoding");//�������ļ���ȡ�����õı��뷽ʽ
		enabled = "true".equalsIgnoreCase(characterEncoding.trim())
				|| "1".equalsIgnoreCase(characterEncoding.trim());//�����ù�������ɱ��뷽ʽ���޸�
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (enabled || characterEncoding != null) {
			request.setCharacterEncoding(characterEncoding);//����request�ı���
			response.setCharacterEncoding(characterEncoding);//����response�ı���
		}
		chain.doFilter(request, response);//doFilter���޸ĺõ�request��response�������´���
	}
	public void destroy() {
		characterEncoding = null;//����ʱ�����Դ
	}
}
