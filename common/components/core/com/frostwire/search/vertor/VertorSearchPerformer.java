/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011, 2012, FrostWire(R). All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.frostwire.search.vertor;

import java.util.List;

import com.frostwire.search.torrent.TorrentJsonSearchPerformer;
import com.frostwire.util.JsonUtils;

/**
 * @author gubatron
 * @author aldenml
 *
 */
public class VertorSearchPerformer extends TorrentJsonSearchPerformer<VertorItem, VertorSearchResult> {

    public VertorSearchPerformer(long token, String keywords, int timeout) {
        super(token, keywords, timeout, 1);
    }

    @Override
    protected String getUrl(int page, String encodedKeywords) {
        return "http://www.vertor.com/index.php?mod=json&search=&words=" + encodedKeywords;
    }

    @Override
    protected List<VertorItem> parseJson(String json) {
        VertorResponse response = JsonUtils.toObject(json, VertorResponse.class);
        return response.results;
    }

    @Override
    protected VertorSearchResult fromItem(VertorItem item) {
        return new VertorSearchResult(item);
    }
}
