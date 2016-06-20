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

package org.uberfire.client.screens;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Composite;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.LinkedGroup;
import org.gwtbootstrap3.client.ui.LinkedGroupItem;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Dependent
@Templated
public class ContactsView extends Composite implements ContactsPresenter.View {

    private ContactsPresenter presenter;

    @Inject
    @DataField("contacts")
    LinkedGroup contacts;

    @Inject
    @DataField("new-contact")
    Button newContact;

    @EventHandler("new-contact")
    public void newContact( ClickEvent event ) {
        presenter.newContact();
    }

    @Override
    public void init( ContactsPresenter presenter ) {
        this.presenter = presenter;
    }

    @Override
    public void addContact( String contactName ) {
        contacts.add( createProjectItems( contactName ) );
    }

    private LinkedGroupItem createProjectItems( final String projectName ) {
        final LinkedGroupItem projectItem = GWT.create( LinkedGroupItem.class );
        projectItem.setText( projectName );
        projectItem.setActive( false );
        return projectItem;
    }
}
