package com.example.apirest_android;

public class Tracks {

        private String title;
        private String singer;
        private String id;

        public Tracks(String title, String singer) {
            this.id = id;
            this.title = title;
            this.singer = singer;
        }

        // Getter for the track ID
        public String getId() {
            return id;
        }

        // Setter for the track ID
        public void setId(String id) {
            this.id = id;
        }

        // Getter for the track title
        public String getTitle() {
            return title;
        }

        // Setter for the track title
        public void setTitle(String title) {
            this.title = title;
        }

        // Getter for the track singer
        public String getSinger() {
            return singer;
        }

        // Setter for the track singer
        public void setSinger(String singer) {
            this.singer = singer;
        }

        /**
         * Overrides the default toString method to provide a formatted string representation of the Track.
         *
         * @return A string containing the ID, title, and singer of the track.
         */
        @Override
        public String toString() {
            return "Track [id=" + id + ", title=" + title + ", singer=" + singer + "]";
        }
    }


