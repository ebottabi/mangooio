package mangoo.io.templating.directives;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import mangoo.io.routing.bindings.Session;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 *
 * @author svenkubiak
 *
 */
@SuppressWarnings("rawtypes")
public class AuthenticityTokenDirective implements TemplateDirectiveModel {
    private Session session;

    public AuthenticityTokenDirective(Session session) {
        this.session = session;
    }

    @Override
    public void execute(Environment environment, Map params, TemplateModel[] loopVars, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        Writer out = environment.getOut();
        out.append(this.session.getAuthenticityToken());
    }
}