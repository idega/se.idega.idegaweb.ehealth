/*
 * Created on 2004-okt-07
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package se.idega.idegaweb.ehealth.presentation;



import com.idega.presentation.IWContext;
import com.idega.presentation.Image;
import com.idega.presentation.Layer;
import com.idega.presentation.Page;
import com.idega.presentation.PresentationObject;
import com.idega.presentation.Script;
import com.idega.presentation.Table;
import com.idega.presentation.text.Break;
import com.idega.presentation.text.Text;
import com.idega.presentation.ui.DateInput;
import com.idega.presentation.ui.DropdownMenu;
import com.idega.presentation.ui.Form;
import com.idega.presentation.ui.GenericButton;
import com.idega.util.IWTimestamp;



/**
 * @author Malin
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class FAQ extends EHealthBlock {
	
	private String prefix = "patient_";
	private String prmForm = prefix + "form_visit";
	
	private String prmCareUnit = prefix + "care_unit";
	private String prmDate = prefix + "date";
	private String prmAppointType = prefix + "appoint_type";
	private String prmPrint = prefix + "print";
	private String prmCost = prefix + "cost";
	private String prmHealthCentre = prefix + "healthcentre";
	private String prmFrom = prefix + "from";
	private String prmTo = prefix + "to";
	private String prmSearch = prefix + "search";
	
	
	
	IWContext _iwc = null;

	public void main(IWContext iwc) throws Exception {
		_iwc = iwc;
		add(getAppointmentHistoryForm());
		
	}
	
	
	
	public PresentationObject getAppointmentHistoryForm(){
		Form myForm = new Form();
		myForm.setName(prmForm);
		Table T = new Table(1, 4);
		T.setCellpadding(0);
		T.setCellspacing(0);
		T.setBorder(0);
		T.setBorderColor("#000000");
		T.setVerticalAlignment(1, 3, Table.VERTICAL_ALIGN_TOP);
		T.setVerticalAlignment(1, 4, Table.VERTICAL_ALIGN_BOTTOM);
		
		//T.add(getSearchSortTable(), 1, 1);
		//T.add(getHeadingTable(), 1, 2);
		T.add(getInfoLayer(), 1, 3);
		//T.add(getTableButtons(), 1, 4);
		
		T.add(new Break(), 1, 3);
		T.setWidth(1, 3, "200");
		T.setHeight(1, 3, "160");		
		T.setHeight(1, 4, "40");
		myForm.add(T);
		
		Page pVisit = this.getParentPage();
		if (pVisit != null) {
			Script S = pVisit.getAssociatedScript();
			pVisit.setOnLoad("setRowColor(document.getElementById('lay1_1'));");
			S.addFunction("setRowColor(obj)", setRowColorScript());
			Script timeScript = myForm.getAssociatedFormScript();
			if (timeScript == null) {
				timeScript = new Script();
				myForm.setAssociatedFormScript(timeScript);
			}
		}
		
		String infoDiv[] = {localize("faq_vkid", "VKID"),localize("faq_how_to", "How to"), localize("faq_personal_info", "Personal info"),
				localize("faq_can_do", "What can I do?"),
				localize("faq_not_log_in", "Cannot log in"),
				localize("faq_browser", "Which browsers?"),
				localize("faq_version_browser", "Version of browser"),
				localize("faq_personal_info", "What is cookies?")};
		
		Layer layer = new Layer(Layer.DIV);
		layer.setVisibility("hidden");
		layer.setPositionType("absolute");
				
		int theRow;
		for (theRow = 1; theRow <= 8; theRow++) {
			Layer layers = (Layer) layer.clone();
			layers.setID("lay" + theRow + "_");			
			layers.add(infoDiv[theRow-1]);
			
			T.add(layers, 1, 3);
		}
		
		
		return myForm;
		
		
	}
	
	
	private Layer getInfoLayer(){
		Layer layerInfo = new Layer(Layer.DIV);
		layerInfo.setOverflow("scroll");
		layerInfo.setPositionType("relative");
		layerInfo.setWidth("610");
		layerInfo.setHeight("100");
		layerInfo.setMarkupAttribute("class", "ehealth_div");
		
		Table tableInfo = new Table(1, 8);
		tableInfo.setNoWrap();
		tableInfo.setCellpadding(0);
		tableInfo.setCellspacing(0);
		tableInfo.setBorder(0);			
		tableInfo.setWidth(570);
		tableInfo.setWidth(1, 1, "400");
	
		Image transpImg = Table.getTransparentCell(_iwc);
		transpImg.setWidth(20);
		transpImg.setHeight(13);
		
		Layer layer = new Layer(Layer.DIV);
		layer.setOnMouseOver("setRowColor(this);");
		layer.setPositionType("relative");
		
		
		int theRow = 1;
		int theColumn = 1;
		
		String questions[] = {"Vad �r ett V�rdkontoID?", "Hur skaffar jag ett v�rdkonto?", "Hur kommer jag �t mina personliga uppgifter?", "Vad kan jag g�ra p� Mitt V�rdkonto?", "Varf�r kan jag inte logga in p� Mitt V�rdkonto?", "Finns det n�gra krav p� vilken webbl�sare jag ska anv�nda?", "Hur ser jag vilken version av Internet Explorer jag har?", "Vad �r cookies?"};
				
		for (theRow = 1; theRow <= 8; theRow++) {
				Layer layers = (Layer) layer.clone();
				layers.setID("lay" + theRow + "_"+ theColumn);
				layers.add(questions[theRow-1]);							
				tableInfo.add(layers, theColumn, theRow);
						
		}
		
		layerInfo.add(tableInfo);
		
		return layerInfo;
	}
	
	private Layer getHeadingTable(){
		Layer layerHead = new Layer(Layer.DIV);
		layerHead.setMarkupAttribute("class", "ehealth_div_no_border");
		
		Table table = new Table(7, 1);
		table.setCellpadding(0);
		table.setCellspacing(0);
		table.setBorder(0);
		table.setWidth(570);
		table.setHeight(20);
		
		
		table.setAlignment(1, 1, Table.HORIZONTAL_ALIGN_LEFT);
		
		
		table.setWidth(1, 1, "100");
		table.setWidth(2, 1, "20");
		table.setWidth(3, 1, "110");
		table.setWidth(4, 1, "20");
		table.setWidth(5, 1, "200");
		table.setWidth(6, 1, "20");
		table.setWidth(7, 1, "100");
		
		Text date = getLocalizedSmallHeader(prmDate,"Date");
		Text careUnit = getLocalizedSmallHeader(prmCareUnit,"Care unit");
		Text regReason = getLocalizedSmallHeader(prmAppointType,"Appointment type");
		Text regCostReceipt = getLocalizedSmallHeader(prmCost,"Cost/receipt");
		
		table.add(date, 1, 1);
		table.add(careUnit, 3, 1);
		table.add(regReason, 5, 1);
		table.add(regCostReceipt, 7, 1);
		
		layerHead.add(table);
		
		return layerHead;
	}
	
	private Table getSearchSortTable(){
		
		Table table = new Table(3, 3);
		table.setCellpadding(0);
		table.setCellspacing(0);
		table.setBorder(0);
		
		table.setVerticalAlignment(1, 1, Table.VERTICAL_ALIGN_BOTTOM);
		table.setVerticalAlignment(3, 1, Table.VERTICAL_ALIGN_BOTTOM);
		table.setVerticalAlignment(1, 2, Table.VERTICAL_ALIGN_BOTTOM);
		table.setVerticalAlignment(1, 3, Table.VERTICAL_ALIGN_BOTTOM);
		
		table.setHeight(1, 1, "25");
		table.setHeight(1, 2, "25");
		table.setHeight(1, 3, "25");
		table.setWidth(2, 1, "20");
		
		IWTimestamp stamp = new IWTimestamp();
		
		DateInput from = (DateInput) getStyledInterface(new DateInput(prmFrom, true));
		from.setYearRange(stamp.getYear() - 11, stamp.getYear()+3);
		
		DateInput to = (DateInput) getStyledInterface(new DateInput(prmTo, true));
		to.setYearRange(stamp.getYear() - 11, stamp.getYear()+3);
		
		DropdownMenu dropHCentre = (DropdownMenu) getStyledInterface(new DropdownMenu(prmHealthCentre));
		dropHCentre.addMenuElementFirst("1", "Gimo VC");
		dropHCentre.addMenuElement("2", "�sthammar VC");
		dropHCentre.addMenuElement("3", "Alunda VC");
		dropHCentre.addMenuElement("4", "�sterbybruk VC");
		dropHCentre.addMenuElement("5", "Tierp VC");
		dropHCentre.addMenuElement("6", "�regrund VC");
		dropHCentre.addMenuElement("7", "Skutsk�r VC");
		dropHCentre.addMenuElement("8", "M�nkarbo VC");
		
		
		
		GenericButton search = getButton(new GenericButton("search", localize(prmSearch, "Search")));
		
		table.add(from, 1, 1);
		table.add(to, 3, 1);
		table.add(dropHCentre, 1, 2);
		table.add(search, 1, 3);
		
		return table;
	}
	
	private String setRowColorScript() {
		StringBuffer s = new StringBuffer();
		
		
		s.append("function setRowColor(obj){").append(" \n\t");
		s.append("elementBase = obj.id.substring(0, 5);").append(" \n\t");
		s.append("for(i=1;i<document.all.tags('div').length;i++){").append(" \n\t");
		s.append("if (document.all.tags('div')[i].id.length == 5){").append(" \n\t");
		s.append("document.all.tags('div')[i].style.visibility = 'hidden'");
		s.append("}").append("\n\t");
		s.append("document.all.tags('div')[i].style.backgroundColor = '#ffffff';");
		s.append("}").append("\n\t");
		s.append("for (i = 1; i <= 1; i++){").append(" \n\t");
		s.append("elementName = eval(elementBase + i);").append(" \n\t");		
		s.append("document.getElementById(elementName.id).style.backgroundColor = '#CCCCCC';").append(" \n\t");
		s.append("}").append("\n\t");
		s.append("showlayer = eval(elementBase + '.id');").append(" \n\t");
		s.append("document.all(showlayer).style.visibility = 'visible';").append(" \n\t");
		
		s.append("}").append("\n\t\t\t");
		
		return s.toString();
	}
	
	
	private Table getTableButtons() {
		Table table = new Table(3, 1);
		table.setCellpadding(0);
		table.setCellspacing(0);
		table.setBorder(0);
		table.setHeight(20);
		
		
		table.setAlignment(1, 1, Table.HORIZONTAL_ALIGN_LEFT);
		
		table.setWidth(2, 1, "20");
		
		
		Image printIcon = (Image) getPrintIcon(_iwc);
		table.add(printIcon, 1, 1);
		
		GenericButton print = getButton(new GenericButton("print", localize(prmPrint, "Print")));
		table.add(print, 3, 1);
		
		
		return table;
		
	}
	
	
}
