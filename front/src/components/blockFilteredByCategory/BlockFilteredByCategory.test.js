import React from 'react';
import { render, screen, waitFor } from '@testing-library/react';
import { MemoryRouter, Route } from 'react-router-dom';
import { rest } from 'msw';
import { setupServer } from 'msw/node';
import BlockFilteredByCategory from './BlockFilteredByCategory';

const server = setupServer(
  rest.get('/api/getAllProducts', (req, res, ctx) => {
    return res(ctx.json([
      {
        id: 1,
        name: 'Product 1',
        categoria: {
          titulo: 'Category 1'
        }
      },
      {
        id: 2,
        name: 'Product 2',
        categoria: {
          titulo: 'Category 2'
        }
      },
      {
        id: 3,
        name: 'Product 3',
        categoria: {
          titulo: 'Category 1'
        }
      },
      {
        id: 4,
        name: 'Product 4',
        categoria: {
          titulo: 'Category 3'
        }
      }
    ]))
  })
);

beforeAll(() => server.listen());
afterEach(() => server.resetHandlers());
afterAll(() => server.close());

describe('BlockFilteredByCategory', () => {
  it('renders "Cargando" when data is being fetched', async () => {
    render(
      <MemoryRouter initialEntries={['/category-1']}>
        <Route path="/:category">
          <BlockFilteredByCategory />
        </Route>
      </MemoryRouter>
    );
    expect(screen.getByText('Cargando')).toBeInTheDocument();
    await waitFor(() => expect(screen.queryByText('Cargando')).not.toBeInTheDocument());
  });

  it('renders products of the selected category', async () => {
    render(
      <MemoryRouter initialEntries={['/category-1']}>
        <Route path="/:category">
          <BlockFilteredByCategory />
        </Route>
      </MemoryRouter>
    );
    await waitFor(() => expect(screen.getByText('Product 1')).toBeInTheDocument());
    expect(screen.queryByText('Product 2')).not.toBeInTheDocument();
    expect(screen.getByText('Product 3')).toBeInTheDocument();
    expect(screen.queryByText('Product 4')).not.toBeInTheDocument();
  });
});
