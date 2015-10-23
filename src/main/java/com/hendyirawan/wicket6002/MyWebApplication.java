package com.hendyirawan.wicket6002;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.ExceptionSettings;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.stereotype.Component;

@Component("webApp")
public class MyWebApplication extends WebApplication {
    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

//    public void mountPages() {
//        new AnnotatedMountScanner().scanPackage(MyWebApplication.class.getPackage().getName()).mount(this);
//    }

    @Override
    public void init() {
        super.init();
        getDebugSettings().setAjaxDebugModeEnabled(false);
        getExceptionSettings().setUnexpectedExceptionDisplay(ExceptionSettings.SHOW_EXCEPTION_PAGE);
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

//        final IBootstrapSettings bootstrapSettings = new BootstrapSettings()
//                .useCdnResources(getConfigurationType() == RuntimeConfigurationType.DEPLOYMENT)
//                .setThemeProvider(new SingleThemeProvider(BootswatchTheme.Cosmo));
//        Bootstrap.install(this, bootstrapSettings);

        //Howler.install(this);

//        mountPages();
    }
}
