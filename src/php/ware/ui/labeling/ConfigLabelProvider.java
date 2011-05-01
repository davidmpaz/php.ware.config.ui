/*
 * generated by Xtext
 */
package php.ware.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.ui.label.StylerFactory;

import php.ware.config.AnnonateEntity;
import php.ware.config.ConfigDeclaration;
import php.ware.config.ConfigModel;
import php.ware.config.Import;
import php.ware.config.Property;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ConfigLabelProvider extends DefaultEObjectLabelProvider {

    @Inject
    public ConfigLabelProvider(AdapterFactoryLabelProvider delegate) {
        super(delegate);
    }

    // Labels and icons can be computed like this:
    StyledString text(ConfigModel ele) {
        return new StyledString(ele.getName(), StyledString.QUALIFIER_STYLER);
    }

    String image(ConfigModel ele) {
        return ele.eClass().getName() + ".gif";
    }

    StyledString text(Import ele) {
        return new StyledString(ele.getImportedNamespace(),
                StyledString.QUALIFIER_STYLER);
    }

    String image(Import ele) {
        return ele.eClass().getName() + ".gif";
    }

    StyledString text(AnnonateEntity ele) {
        StyledString ss = new StyledString();
        if (ele.getFeature() == null) {
            return ss
                    .append(ele.getElement().getName())
                    .append(" -> ", this.getKeysStyler())
                    .append(ele.getElement().eClass().getName(),
                            StyledString.QUALIFIER_STYLER);
        } else {
            return ss
                    .append(ele.getElement().getName(),
                            StyledString.COUNTER_STYLER)
                    .append("::", this.getKeysStyler())
                    .append(ele.getFeature().getName(),
                            StyledString.COUNTER_STYLER)
                    .append(" -> ", this.getKeysStyler())
                    .append(ele.getElement().eClass().getName(),
                            StyledString.QUALIFIER_STYLER)
                    .append(" " + ele.getFeature().eClass().getName(),
                            StyledString.QUALIFIER_STYLER);
        }
    }

    String image(AnnonateEntity ele) {
        return ele.eClass().getName() + ".gif";
    }

    String text(ConfigDeclaration ele) {
        return ele.getElement().toString();
    }

    String image(ConfigDeclaration ele) {
        return ele.eClass().getName() + ".gif";
    }

    StyledString text(Property ele) {
        StyledString ss = new StyledString();
        if (ele.getPropertyValue().isEmpty())
            return ss.append(ele.getPropertyName());
        else
            return ss
                    .append(ele.getPropertyName())
                    .append(" = ", this.getKeysStyler())
                    .append(ele.getPropertyValue(),
                            this.getPropertyValueStyler());
    }

    String image(Property ele) {
        return ele.eClass().getName() + ".gif";
    }

    protected Styler getPropertyValueStyler() {

        StylerFactory sf = new StylerFactory();
        TextStyle ts = new TextStyle();

        ts.setStyle(SWT.NORMAL);
        ts.setColor(new RGB(200, 0, 0));
        ts.setBackgroundColor(new RGB(255, 255, 255));

        return sf.createXtextStyleAdapterStyler(ts);
    }

    protected Styler getKeysStyler() {

        StylerFactory sf = new StylerFactory();
        TextStyle ts = new TextStyle();

        ts.setStyle(SWT.NORMAL);
        ts.setColor(new RGB(255, 168, 35));
        ts.setBackgroundColor(new RGB(255, 255, 255));

        return sf.createXtextStyleAdapterStyler(ts);
    }
}
