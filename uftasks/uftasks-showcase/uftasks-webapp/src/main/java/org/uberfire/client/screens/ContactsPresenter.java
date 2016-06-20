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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.annotations.WorkbenchScreen;
import org.uberfire.client.mvp.UberView;
import org.uberfire.client.screens.popup.NewContactPresenter;
import org.uberfire.shared.model.Contact;

@ApplicationScoped
@WorkbenchScreen(identifier = "ContactsPresenter")
public class ContactsPresenter {

    public interface View extends UberView<ContactsPresenter> {

        void addContact( String contactName );

    }

    @Inject
    private NewContactPresenter newContactPresenter;

    @Inject
    private View view;


    public void newContact() {
        newContactPresenter.show( this );
    }

    public void addContact( Contact contact ) {
        view.addContact( contact.getName() );
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "Contacts";
    }

    @WorkbenchPartView
    public UberView<ContactsPresenter> getView() {
        return view;
    }
}
