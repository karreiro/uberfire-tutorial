/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.client.screens.popup;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Composite;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.ModalBody;
import org.gwtbootstrap3.client.ui.TextBox;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Dependent
@Templated
public class NewContactView extends Composite implements NewContactPresenter.View {

    private NewContactPresenter presenter;

    private Modal modal;

    @Inject
    @DataField("contact-name")
    TextBox nameTextBox;

    @Inject
    @DataField("contact-email")
    TextBox emailTextBox;

    @Inject
    @DataField("contact-phone")
    TextBox phoneTextBox;

    @Inject
    @DataField("ok-button")
    Button okButton;

    @Inject
    @DataField("cancel-button")
    Button cancelButton;

    @Override
    public void init( NewContactPresenter presenter ) {
        this.presenter = presenter;

        this.modal = new Modal();
        final ModalBody body = new ModalBody();
        body.add( this );
        modal.add( body );
    }

    @Override
    public void show() {
        modal.show();
    }

    @Override
    public void hide() {
        modal.hide();
        nameTextBox.setText( "" );
        emailTextBox.setText( "" );
        phoneTextBox.setText( "" );
    }

    @EventHandler("ok-button")
    public void addProject( ClickEvent event ) {
        presenter.addContact( nameTextBox.getText(), emailTextBox.getText(), phoneTextBox.getText() );
    }

    @EventHandler("cancel-button")
    public void cancel( ClickEvent event ) {
        presenter.close();
    }
}
