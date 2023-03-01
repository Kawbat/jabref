package org.jabref.gui.search;

import com.google.common.collect.Lists;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import org.jabref.gui.AbstractViewModel;
import org.jabref.gui.ClipBoardManager;
import org.jabref.gui.DialogService;
import org.jabref.gui.desktop.JabRefDesktop;
import org.jabref.logic.l10n.Localization;
import org.jabref.logic.util.BuildInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class HistoryDialogViewModel extends AbstractViewModel {

    private final String searchHistories;
    private final DialogService dialogService;
    private final ReadOnlyStringWrapper developmentVersion = new ReadOnlyStringWrapper();
    private final ClipBoardManager clipBoardManager;

    public HistoryDialogViewModel(DialogService dialogService, ClipBoardManager clipBoardManager) {
        this.dialogService = Objects.requireNonNull(dialogService);
        this.clipBoardManager = Objects.requireNonNull(clipBoardManager);

        String histories = "history0\n";
        String history1 = "history1";
        String history2 = "history2";
        histories = histories.concat(history1);
        histories = histories.concat("\n");
        histories = histories.concat(history2);
        histories = histories.concat("\n");
        searchHistories = histories;
    }

    public String getSearchHistories() { return searchHistories;}

    public void copyHistoryToClipboard() {
        clipBoardManager.setContent(searchHistories);
        dialogService.notify(Localization.lang("Copied search histories to clipboard"));
    }

}
