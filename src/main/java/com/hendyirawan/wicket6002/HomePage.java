package com.hendyirawan.wicket6002;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

    public HomePage(PageParameters parameters) {
        super(parameters);
        final Form form = new Form<Void>("form");
        final ListModel<FileUpload> fileUploadsModel = new ListModel<>();
        final FileUploadField fileFld = new FileUploadField("fileFld", fileUploadsModel);
        // TRY THIS: fileFld.setVisible(false);
        form.add(fileFld);
        final Model<String> textModel = new Model<>("Bismillah");
        form.add(new TextField<>("textFld", textModel));
        form.add(new AjaxButton("saveBtn") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                super.onSubmit(target, form);
                target.appendJavaScript("alert('You typed: ' + " + JSONObject.quote(textModel.getObject()) + ");");
            }
        });
        add(form);
    }

}
