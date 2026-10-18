-- Foreign key indexes back the per-user URL listing and the analytics/delete queries.
CREATE INDEX idx_urls_user_id ON urls (user_id);
CREATE INDEX idx_analytics_event_url_id ON analytics_event (url_id);

-- User-Agent and Referer headers regularly exceed 255 characters, which made
-- the redirect fail when recording the click.
ALTER TABLE analytics_event MODIFY COLUMN device TEXT;
ALTER TABLE analytics_event MODIFY COLUMN referrer TEXT;

UPDATE urls SET click_count = 0 WHERE click_count IS NULL;
ALTER TABLE urls MODIFY COLUMN click_count BIGINT NOT NULL DEFAULT 0;
