import React, {useEffect, useState} from 'react';
import {Route, Routes, BrowserRouter, useNavigate} from 'react-router-dom';
import Appbar from '../components/appbar/Appbar';
import ReleaseNotes from '../components/releaseNotes/ReleaseNotes';
import DocsHome from '../screens/docs/Home';
import DocsLayout from '../screens/docs/DocsLayout';
import Drafts from '../screens/docs/Drafts';
import Archive from '../screens/docs/Archive';
import Trash from '../screens/docs/Trash';
import DocumentView from '../screens/docs/DocumentView';
import CollectionView from '../screens/docs/CollectionView';
import CreateDocs from '../screens/docs/CreateDocs';
import EditDocs from '../screens/docs/EditDocs';
import HistoryView from '../screens/docs/HistoryView';

const AppRouter = ({signOut, user}) => {
  const [formId, setFormId] = useState();
  const navigate = useNavigate();
  useEffect(() => {
    navigate('/docs/home')

  }, []);

  return (
    <>
      {window.location.pathname !== '/release-notes' &&
        <Appbar signOut={signOut} user={user} />}{' '}
      <Routes>
          <>
            {/* Docs Route Start */}
            <Route path="/docs" element={<DocsLayout />}>
              <Route index element={<DocsHome />} />
              <Route path="home" element={<DocsHome />} />
              <Route path="drafts" element={<Drafts />} />
              <Route path="archive" element={<Archive />} />
              <Route path="trash" element={<Trash />} />
              <Route path=":id" element={<DocumentView />} />
              <Route path="collection/:id" element={<CollectionView />} />
              <Route
                path="/docs/:id/history/:historyId"
                element={<HistoryView />}
              />
            </Route>
            <Route path="/docs/create/:id" element={<CreateDocs />} />
            <Route path="/docs/edit/:id" element={<EditDocs />} />
            {/* Docs Route End */}
            </>
      </Routes>
      {/* <Footer /> */}
    </>
  );
};

export default AppRouter;
