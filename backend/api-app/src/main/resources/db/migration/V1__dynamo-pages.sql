-- Create schema dynamo
CREATE SCHEMA IF NOT EXISTS dynamo;

-- Create collection sequence
DROP SEQUENCE IF EXISTS dynamo.collection_seq;
CREATE SEQUENCE dynamo.collection_seq
  START WITH 1
  INCREMENT BY 1;

-- Create collection table
DROP TABLE IF EXISTS dynamo.collection;
CREATE TABLE dynamo.collection (
    id BIGINT NOT NULL DEFAULT (NEXT VALUE FOR dynamo.collection_seq),
    unique_id UUID NOT NULL UNIQUE,
    name TEXT NOT NULL,
    description TEXT,
    permission VARCHAR(25) NOT NULL,
    created_by_user_id VARCHAR(100) NOT NULL,
    created_on TIMESTAMP,
    modified_on TIMESTAMP,
    CONSTRAINT collection_pkey PRIMARY KEY (id)
);

-- Create document sequence
DROP SEQUENCE IF EXISTS dynamo.document_seq;
CREATE SEQUENCE dynamo.document_seq
  START WITH 1
  INCREMENT BY 1;

-- Create document table
DROP TABLE IF EXISTS dynamo.document;
CREATE TABLE dynamo.document (
    id BIGINT NOT NULL DEFAULT (NEXT VALUE FOR dynamo.document_seq),
    unique_id UUID NOT NULL UNIQUE,
    title TEXT,
    content TEXT,
    status VARCHAR(25),
    version BIGINT,
    revision_count BIGINT,
    published_on TIMESTAMP,
    archived_on TIMESTAMP,
    deleted_on TIMESTAMP,
    created_on TIMESTAMP,
    modified_on TIMESTAMP,
    parent_document_id UUID,
    collection_id UUID,
    created_by_user_id VARCHAR(100) NOT NULL,
    CONSTRAINT document_pkey PRIMARY KEY (id),
    CONSTRAINT document_parent_fkey FOREIGN KEY (parent_document_id)
      REFERENCES dynamo.document(unique_id) ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT document_collection_fkey FOREIGN KEY (collection_id)
      REFERENCES dynamo.collection(unique_id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

---- Create attachment sequence
DROP SEQUENCE IF EXISTS dynamo.attachment_seq;
CREATE SEQUENCE dynamo.attachment_seq
  START WITH 1
  INCREMENT BY 1;

-- Create attachment table
DROP TABLE IF EXISTS dynamo.attachment;
CREATE TABLE dynamo.attachment (
    id BIGINT NOT NULL DEFAULT (NEXT VALUE FOR dynamo.attachment_seq),
    unique_id UUID NOT NULL UNIQUE,
    document_id UUID NOT NULL,
    name TEXT,
    type VARCHAR(25),
    "key" TEXT,
    size VARCHAR(20),
    created_on TIMESTAMP,
    modified_on TIMESTAMP,
    created_by_user_id VARCHAR(100) NOT NULL,
    CONSTRAINT attachment_pkey PRIMARY KEY (id),
    CONSTRAINT attachment_document_fkey FOREIGN KEY (document_id)
      REFERENCES dynamo.document(unique_id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Create revision sequence
DROP SEQUENCE IF EXISTS dynamo.revision_seq;
CREATE SEQUENCE dynamo.revision_seq
  START WITH 1
  INCREMENT BY 1;

-- Create revision table
DROP TABLE IF EXISTS dynamo.revision;
CREATE TABLE dynamo.revision (
    id BIGINT NOT NULL DEFAULT (NEXT VALUE FOR dynamo.revision_seq),
    unique_id UUID NOT NULL UNIQUE,
    document_id UUID NOT NULL,
    title TEXT,
    content TEXT,
    version BIGINT,
    status VARCHAR(25),
    edited_by_user_id VARCHAR(100) NOT NULL,
    edited_on TIMESTAMP,
    created_on TIMESTAMP,
    modified_on TIMESTAMP,
    CONSTRAINT revision_pkey PRIMARY KEY (id),
    CONSTRAINT revision_document_fkey FOREIGN KEY (document_id)
      REFERENCES dynamo.document(unique_id) ON UPDATE NO ACTION ON DELETE NO ACTION
);
