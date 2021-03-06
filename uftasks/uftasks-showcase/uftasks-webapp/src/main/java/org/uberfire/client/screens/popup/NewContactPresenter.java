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

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.uberfire.client.mvp.UberView;
import org.uberfire.client.screens.ContactsPresenter;
import org.uberfire.shared.model.Contact;

@Dependent
public class NewContactPresenter {

    private ContactsPresenter contactsPresenter;

    public interface View extends UberView<NewContactPresenter> {

        void show();

        void hide();
    }

    @Inject
    private View view;

    @PostConstruct
    public void setup() {
        view.init( this );
    }

    public void close() {
        view.hide();
    }

    public void addContact( String name, String email, String phone ) {
        contactsPresenter.addContact( new Contact( name, email, phone ) );
        view.hide();
    }

    public void show( ContactsPresenter contactsPresenter ) {
        this.contactsPresenter = contactsPresenter;
        view.show();
    }
}
