/**********************************************************************
 * Copyright (c) by Heiner Jostkleigrewe
 * This program is free software: you can redistribute it and/or modify it under the terms of the 
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See 
 *  the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.  If not, 
 * see <http://www.gnu.org/licenses/>.
 * 
 * heiner@jverein.de
 * www.jverein.de
 **********************************************************************/
package de.jost_net.JVerein.gui.view;

import de.jost_net.JVerein.gui.action.DokumentationAction;
import de.jost_net.JVerein.gui.control.DbBereinigenControl;
import de.willuhn.jameica.gui.AbstractView;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.parts.ButtonArea;
import de.willuhn.jameica.gui.util.ColumnLayout;
import de.willuhn.jameica.gui.util.LabelGroup;
import de.willuhn.jameica.gui.util.SimpleContainer;

public class DbBereinigenView extends AbstractView
{

  @Override
  public void bind() throws Exception
  {
    GUI.getView().setTitle("Datenbank bereinigen");

    final DbBereinigenControl control = new DbBereinigenControl(this);

    LabelGroup groupspendenbescheinigungen = new LabelGroup(getParent(), "Spendenbescheinigungen");
    ColumnLayout scl = new ColumnLayout(groupspendenbescheinigungen.getComposite(), 2);
    SimpleContainer sleft = new SimpleContainer(scl.getComposite());
    sleft.addLabelPair("L�schen", control.getSpendenbescheinigungenLoeschen());
    SimpleContainer sright = new SimpleContainer(scl.getComposite());
    sright.addLabelPair("Spendedatum �lter als", control.getDatumAuswahlSpendenbescheinigungen());
    
    LabelGroup groupbuchungen = new LabelGroup(getParent(), "Buchungen");
    ColumnLayout bcl = new ColumnLayout(groupbuchungen.getComposite(), 2);
    SimpleContainer bleft = new SimpleContainer(bcl.getComposite());
    bleft.addLabelPair("L�schen", control.getBuchungenLoeschen());
    SimpleContainer bright = new SimpleContainer(bcl.getComposite());
    bright.addLabelPair("Datum �lter als", control.getDatumAuswahlBuchungen());
    bright.addLabelPair("Zugeordnete Sollbuchungen l�schen", control.getSollbuchungenLoeschen());
    
    LabelGroup grouplastschriften = new LabelGroup(getParent(), "Lastschriften");
    ColumnLayout lcl = new ColumnLayout(grouplastschriften.getComposite(), 2);
    SimpleContainer lleft = new SimpleContainer(lcl.getComposite());
    lleft.addLabelPair("L�schen", control.getLastschriftenLoeschen());
    SimpleContainer lright = new SimpleContainer(lcl.getComposite());
    lright.addLabelPair("F�lligkeit �lter als", control.getDatumAuswahlLastschriften());

    LabelGroup groupmails = new LabelGroup(getParent(), "Mails");
    ColumnLayout mcl = new ColumnLayout(groupmails.getComposite(), 2);
    SimpleContainer mleft = new SimpleContainer(mcl.getComposite());
    mleft.addLabelPair("L�schen", control.getMailsLoeschen());
    SimpleContainer mright = new SimpleContainer(mcl.getComposite());
    mright.addLabelPair("Versand �lter als", control.getDatumAuswahlMails());

    ButtonArea buttons = new ButtonArea();
    buttons.addButton("Hilfe", new DokumentationAction(),
        DokumentationUtil.BEREINIGEN, false, "question-circle.png");
    buttons.addButton(control.getStartLoeschenButton());
    buttons.paint(this.getParent());
  }
}